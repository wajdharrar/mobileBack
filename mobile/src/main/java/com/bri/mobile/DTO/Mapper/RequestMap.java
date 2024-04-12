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
                .equity(request.getEquity())
                .repayement(request.getRepayement())
                .state(request.getState())
                .borrowerType(request.getBorowerType())
                .user(UserMap.toUserDto(request.getUser()))
                .date(request.getDate())
                .documents(DocumentMap.toDocumentListDto(request.getDocuments()))
                .build();
    }
    public static Request toRequestEntity (RequestDto requestDto){
        return Request.builder()
                .idRequest(requestDto.getIdRequest())
                .equity(requestDto.getEquity())
                .repayement(requestDto.getRepayement())
                .borowerType(requestDto.getBorrowerType())
                .state(requestDto.getState())
                .user(UserMap.toUserEntity(requestDto.getUser()))
                .date(requestDto.getDate())
                .documents(DocumentMap.toDocumentListEntity(requestDto.getDocuments()))
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
