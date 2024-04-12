package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.RequestMap;
import com.bri.mobile.DTO.model.RequestDto;
import com.bri.mobile.DTO.model.UserDto;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Entity.User;
import com.bri.mobile.Face.RequestFace;
import com.bri.mobile.Repo.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService implements RequestFace {
    @Autowired
    RequestRepo requestRepo;
    public List<RequestDto> getAllRequests(){
        List <Request>requests=requestRepo.findAll();
        return RequestMap.toRequestListDto(requests);
    }
    public RequestDto getRequestById(int id){
        return null;
    }
    public RequestDto addRequest(RequestDto request){
        return null;
    }
    public RequestDto updateRequest(RequestDto request, int id){
        return null;
    }
    public void deleteRequest(int id){
    }
    public List<RequestDto> getByUserId(User user){
        List <Request>requests=requestRepo.findByIdUser(user);
        return RequestMap.toRequestListDto(requests);
    }

}
