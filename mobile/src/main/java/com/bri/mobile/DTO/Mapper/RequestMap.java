package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.RequestDto;
import com.bri.mobile.DTO.model.RoleDto;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Entity.Role;

import java.util.List;
import java.util.stream.Collectors;

public class RequestMap {
    public static RequestDto toRequestDto (Request request){
        return RequestDto.builder()
                .idRequest(request.getIdRequest())
                .initialPayment(request.getInitialPayment())
                .warranty(request.getWarranty())
                .repayement(request.getRepayement())
                .state(request.getState())
                .date(request.getDate())
                .user(UserMap.toUserDto(request.getUser()))
                .build();
    }
    public static Request toRequestEntity (RequestDto requestDto){
        return Request.builder()
                .idRequest(requestDto.getIdRequest())
                .initialPayment(requestDto.getInitialPayment())
                .warranty(requestDto.getWarranty())
                .repayement(requestDto.getRepayement())
                .state(requestDto.getState())
                .date(requestDto.getDate())
                .user(UserMap.toUserEntity(requestDto.getUser()))
                .build();
    }
    public static List<RequestDto> toRequestListDto(List<Request> requests){
        return requests.stream()
                .map(request ->toRequestDto(request))
                .collect(Collectors.toList());
    }
    public static List<Request> toRequestListEntity(List<RequestDto> requestsDto ){
        return requestsDto.stream()
                .map(requestDto ->toRequestEntity(requestDto))
                .collect(Collectors.toList());
    }
}