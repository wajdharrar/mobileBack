package com.bri.mobile.Face;


import com.bri.mobile.DTO.model.RequestDto;
import com.bri.mobile.DTO.model.UserDto;
import com.bri.mobile.Entity.Provider;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Entity.User;

import java.util.List;

public interface RequestFace {
    public List<RequestDto> getAllRequests();
    public RequestDto getRequestById(int id);
    public RequestDto addRequest(RequestDto request);
    public RequestDto updateRequest(RequestDto request, int id);
    public void deleteRequest(int id);
    public List<RequestDto> getByUserId( User user);
}
