package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.RequestMap;
import com.bri.mobile.DTO.model.RequestDto;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Entity.User;
import com.bri.mobile.Enum.State;
import com.bri.mobile.Face.RequestFace;
import com.bri.mobile.Repo.RequestRepo;
import com.bri.mobile.tool.stat.*;
import io.opencensus.stats.Aggregation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestService implements RequestFace {
    @Autowired
    RequestRepo requestRepo;
    public List<RequestDto> getAllRequests(){
        List <Request>requests=requestRepo.findAll();
        return RequestMap.toRequestListDto(requests);
    }
    public RequestDto getRequestById(int id){
        Optional<Request> requestTest=requestRepo.findById(id);
        if(requestTest.isPresent()) {
            return RequestMap.toRequestDto(requestTest.get());
        }else{
            throw new RuntimeException("Request Not Found");
        }
    }
    public RequestDto addRequest(RequestDto request){
        return RequestMap.toRequestDto(requestRepo.save(RequestMap.toRequestEntity(request)));
    }
    public RequestDto updateRequest(RequestDto request, int id){
        Optional<Request> testRequest= requestRepo.findById(id);
        if(testRequest.isPresent()){
            Request oldRequest=testRequest.get();
            oldRequest.setReason(request.getReason());
            oldRequest.setInitialPayment(request.getInitialPayment());
            oldRequest.setRepayement(request.getRepayement());
            oldRequest.setWarranty(request.getWarranty());
            return RequestMap.toRequestDto(requestRepo.save(oldRequest));
        }else{
            throw new RuntimeException("Request Not Found");
        }
    }
    public void deleteRequest(int id){
        requestRepo.deleteById(id);
    }
    public List<RequestDto> getByUserId(User user){
        return RequestMap.toRequestListDto(requestRepo.findByUser(user));
    }

    @Override
    public RequestDto updateState(RequestDto requestDto,int id) {
        System.out.println(requestDto.getState());
        Optional<Request> testRequest= requestRepo.findById(id);
        if(testRequest.isPresent()){
            Request oldRequest=testRequest.get();
            oldRequest.setReason(requestDto.getReason());
            oldRequest.setState(requestDto.getState());

            return RequestMap.toRequestDto(requestRepo.save(oldRequest));
        }else{
            throw new RuntimeException("Request Not Found");
        }
    }
    public double calculateTotalForToday() {
        LocalDate today = LocalDate.now();
        LocalDateTime startDateTime = today.atTime(1, 0);
        Timestamp startDate = Timestamp.valueOf(startDateTime);

        Double totalRepayment = requestRepo.calculateTotalRepaymentForToday(startDate);
        Double totalInitialPayment = requestRepo.calculateTotalInitialPaymentForToday(startDate);
        if(totalRepayment==null){
            totalRepayment=0.0;
        }
        if(totalInitialPayment==null){
            totalInitialPayment=0.0;
        }
        return totalRepayment + totalInitialPayment;
    }
    public double countRequest() {
        LocalDate today = LocalDate.now();
        LocalDateTime startDateTime = today.atTime(1, 0);
        Timestamp startDate = Timestamp.valueOf(startDateTime);
        System.out.println(startDate);
        System.out.println(requestRepo.countRequest(startDate));
        Integer count = requestRepo.countRequest(startDate);
        System.out.println(count);
        if(count==null){
            count=0;
        }
        return count;
    }
    public double countRequestForPartner(Long id) {
        LocalDate today = LocalDate.now();
        LocalDateTime startDateTime = today.atTime(1, 0);
        Timestamp startDate = Timestamp.valueOf(startDateTime);
        double countRepay = requestRepo.calculateTotalRepaymentForPartnerAndDate(id,startDate);
        double countInit = requestRepo.calculateTotalInitialPaymentForPartnerAndDate(id,startDate);
        return countRepay+countInit;
    }
    public List<RequestStateCount> countRequestsByState() {
        List<Object[]> requestStateCounts = requestRepo.countRequestsByState();

        return requestStateCounts.stream()
                .map(objects -> new RequestStateCount((State) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
    }
    public List<RequestDeviceCount> countRequestsByDevice() {
        List<Object[]> requestDeviceCounts = requestRepo.countRequestsByDevice();

        return requestDeviceCounts.stream()
                .map(objects -> new RequestDeviceCount((String) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
    }
    public Long countRequestsForPartner(Long id){
        return requestRepo.countRequestsForPartner(id);
    }
    public List<RequestBrandCount> countRequestsByBrand() {
        List<Object[]> requestBrandCounts = requestRepo.countRequestsByBrand();

        return requestBrandCounts.stream()
                .map(objects -> new RequestBrandCount((String) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
    }
    public List<RequestDeviceTypeCount> countRequestsByDeviceType() {
        List<Object[]> requestDeviceTypeCounts = requestRepo.countRequestsByDeviceType();

        return requestDeviceTypeCounts.stream()
                .map(objects -> new RequestDeviceTypeCount((String) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
    }
    public List<RequestProviderCount> countRequestsByProvider() {
        List<Object[]> requestProviderCounts = requestRepo.countRequestsByPartner();

        return requestProviderCounts.stream()
                .map(objects -> new RequestProviderCount((String) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
    }
    public List<DeviceAttributeCount> countRequestsByBrandForPartner(Long id) {
        List<Object[]> requestProviderBrandCounts = requestRepo.countRequestsByBrandForPartner(id);

        return requestProviderBrandCounts.stream()
                .map(objects -> new DeviceAttributeCount((String) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
    }
    public List<DeviceAttributeCount> countRequestsByDeviceForPartner(Long id) {
        List<Object[]> requestProviderDeviceCounts = requestRepo.countRequestsByDeviceForPartner(id);

        return requestProviderDeviceCounts.stream()
                .map(objects -> new DeviceAttributeCount((String) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
    }
    public List<DeviceAttributeCount> countRequestsByModelForPartner(Long id) {
        List<Object[]> requestProviderModelCounts = requestRepo.countRequestsByModelForPartner(id);

        return requestProviderModelCounts.stream()
                .map(objects -> new DeviceAttributeCount((String) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
    }
    public List<DeviceAttributeCount> countRequestsByVersionForPartner(Long id) {
        List<Object[]> requestProviderVersionCounts = requestRepo.countRequestsByVersionForPartner(id);

        return requestProviderVersionCounts.stream()
                .map(objects -> new DeviceAttributeCount((String) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
    }
    public List<DeviceAttributeCount> countRequestsByDeviceType(Long id) {
        List<Object[]> requestProviderDeviceTypeCounts = requestRepo.countRequestsByDeviceType(id);

        return requestProviderDeviceTypeCounts.stream()
                .map(objects -> new DeviceAttributeCount((String) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
    }
    public List <EntityStateCount>countRequestsByStateForUser(Long id){
        List<Object[]>countRequestsUser=requestRepo.countRequestsByStateForUser(id);
        return countRequestsUser.stream()
                .map(objects -> new EntityStateCount((State) objects[0],(Long) objects[1]))
                .collect(Collectors.toList());
    }
}
