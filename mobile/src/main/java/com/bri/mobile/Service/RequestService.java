package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.RequestMap;
import com.bri.mobile.DTO.model.RequestDto;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Entity.User;
import com.bri.mobile.Enum.State;
import com.bri.mobile.Face.RequestFace;
import com.bri.mobile.Repo.RequestRepo;
import com.bri.mobile.tool.stat.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
        LocalDateTime startDateTime = LocalDate.now().atStartOfDay();
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
        LocalDateTime startDateTime = LocalDate.now().atStartOfDay();
        Timestamp startDate = Timestamp.valueOf(startDateTime);

        Integer count = requestRepo.countRequest(startDate);
        if(count==null){
            count=0;
        }
        return count;
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
}
