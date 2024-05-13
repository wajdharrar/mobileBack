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
        return requestService.updateRequest(requestDto,id);
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
}
