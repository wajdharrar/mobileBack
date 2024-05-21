package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.RequestDto;
import com.bri.mobile.Entity.User;
import com.bri.mobile.Service.RequestService;
import com.bri.mobile.tool.stat.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {
    @Autowired
    RequestService requestService;
    @PostMapping("/user")
    List<RequestDto> getRequestByUserId(@RequestBody User user){
        return requestService.getByUserId(user);
    }
    @PostMapping("/add")
    RequestDto addRequest(@RequestBody RequestDto requestDto){
        return requestService.addRequest(requestDto);
    }
    @GetMapping("/requests")
    List<RequestDto>getAllRequests(){
        return requestService.getAllRequests();
    }
    @GetMapping("/{id}")
    RequestDto getRequestById(@PathVariable int id){
        return requestService.getRequestById(id);
    }
    @DeleteMapping("/delete/{id}")
    void deleteRequest(@PathVariable int id ){
        requestService.deleteRequest(id);
    }
    @PutMapping("/update/{id}")
    RequestDto updateRequest(@PathVariable int id,@RequestBody RequestDto requestDto){
        return requestService.updateRequest(requestDto,id);
    }
    @PutMapping("/updatestate/{id}")
    RequestDto updateRequestState(@PathVariable int id,@RequestBody RequestDto requestDto){
        return requestService.updateState(requestDto,id);
    }
    @GetMapping("/total")
    double getTotal(){
        return requestService.calculateTotalForToday();
    }
    @GetMapping("/count")
    double getCount(){
        return requestService.countRequest();
    }
    @GetMapping("/state")
    List<RequestStateCount> getRequestByState(){
        return requestService.countRequestsByState();
    }
    @GetMapping("/brand")
    List<RequestBrandCount> getRequestByBrand(){
        return requestService.countRequestsByBrand();
    }
    @GetMapping("/device")
    List<RequestDeviceCount> getRequestByDevice(){
        return requestService.countRequestsByDevice();
    }
    @GetMapping("/devicetype")
    List<RequestDeviceTypeCount> getRequestByDeviceType(){
        return requestService.countRequestsByDeviceType();
    }
    @GetMapping("/partner")
    List<RequestProviderCount> getRequestByPartner(){
        return requestService.countRequestsByProvider();
    }
    @GetMapping("/total/partner/{id}")
    double pr(@PathVariable Long id){
        return requestService.countRequestForPartner(id);
    }
    @GetMapping("/total/requests/{id}")
    Long countRequestsForPartner(@PathVariable Long id){
        return requestService.countRequestsForPartner(id);
    }
    @GetMapping("/brand/partner/{id}")
    List<DeviceAttributeCount> p(@PathVariable Long id){
        return requestService.countRequestsByBrandForPartner(id);
    }
    @GetMapping("/device/partner/{id}")
    List<DeviceAttributeCount> countRequestsByDeviceForPartner(@PathVariable Long id){
        return requestService.countRequestsByDeviceForPartner(id);
    }
    @GetMapping("/model/partner/{id}")
    List<DeviceAttributeCount> countRequestsByModelForPartner(@PathVariable Long id){
        return requestService.countRequestsByModelForPartner(id);
    }
    @GetMapping("/version/partner/{id}")
    List<DeviceAttributeCount> countRequestsByVersionForPartner(@PathVariable Long id){
        return requestService.countRequestsByVersionForPartner(id);
    }
    @GetMapping("/devicetype/partner/{id}")
    List<DeviceAttributeCount> countRequestsByDeviceType(@PathVariable Long id){
        return requestService.countRequestsByDeviceType(id);
    }
    @GetMapping("/state/client/{id}")
    List <EntityStateCount>countRequestsByStateForUser(@PathVariable Long id){
        return requestService.countRequestsByStateForUser(id);
    }
}
