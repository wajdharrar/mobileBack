package com.bri.mobile.Face;


import com.bri.mobile.DTO.model.RequestDto;
import com.bri.mobile.Entity.User;
import com.bri.mobile.tool.stat.*;

import java.util.List;

public interface RequestFace {
    public List<RequestDto> getAllRequests();
    public RequestDto getRequestById(int id);
    public RequestDto addRequest(RequestDto request);
    public RequestDto updateRequest(RequestDto request, int id);
    public void deleteRequest(int id);
    public List<RequestDto> getByUserId( User user);
    RequestDto updateState(RequestDto requestDto,int id);
    public double calculateTotalForToday();
    public double countRequest();
    List<RequestStateCount> countRequestsByState();
    List<RequestDeviceCount> countRequestsByDevice();
    List<RequestBrandCount> countRequestsByBrand();
    List<RequestDeviceTypeCount> countRequestsByDeviceType();
    List<RequestProviderCount> countRequestsByProvider();
}
