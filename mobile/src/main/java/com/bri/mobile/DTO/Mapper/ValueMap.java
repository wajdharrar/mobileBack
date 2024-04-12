package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.RoleDto;
import com.bri.mobile.DTO.model.ValueDto;
import com.bri.mobile.Entity.Role;
import com.bri.mobile.Entity.Value;

import java.util.List;
import java.util.stream.Collectors;

public class ValueMap {
    public static ValueDto toValueDto(Value value){
        return ValueDto.builder()
                .idValue(value.getIdValue())
                .valValeu(value.getValValeu())
                .state(value.getState())
                .reason(value.getReason())
                .unit(value.getUnit())
                .feature(value.getFeature())
                .build();
    }
    public static Value toValueEntity(ValueDto valueDto){
        return Value.builder()
                .idValue(valueDto.getIdValue())
                .valValeu(valueDto.getValValeu())
                .state(valueDto.getState())
                .reason(valueDto.getReason())
                .unit(valueDto.getUnit())
                .feature(valueDto.getFeature())
                .build();
    }
    public static List<ValueDto> toValueListDto(List<Value> values){
        return values.stream()
                .map(value ->toValueDto(value))
                .collect(Collectors.toList());
    }
    public static List<Value> toValueListEntity(List<ValueDto> valueDtos ){
        return valueDtos.stream()
                .map(valueDto ->toValueEntity(valueDto))
                .collect(Collectors.toList());
    }
}
