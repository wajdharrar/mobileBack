package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.RequestDto;
import com.bri.mobile.DTO.model.UserDto;
import com.bri.mobile.Entity.User;
import com.bri.mobile.Service.RequestService;
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
    @GetMapping("/requests")
    List<RequestDto>getAllRequests(){
        return requestService.getAllRequests();
    }
}
