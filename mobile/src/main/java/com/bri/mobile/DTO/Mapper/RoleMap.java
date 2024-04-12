package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.GiftDto;
import com.bri.mobile.DTO.model.RoleDto;
import com.bri.mobile.Entity.Gift;
import com.bri.mobile.Entity.Role;

import java.util.List;
import java.util.stream.Collectors;

public class RoleMap {
    public static RoleDto toRoleDto(Role role){
        return RoleDto.builder()
                .idRole(role.getIdRole())
                .nameRole(role.getNameRole())
                .build();
    }
    public static Role toRoleEntity(RoleDto roleDto){
        return Role.builder()
                .idRole(roleDto.getIdRole())
                .nameRole(roleDto.getNameRole())
                .build();
    }
    public static List<RoleDto> toRoleListDto(List<Role> roles){
        return roles.stream()
                .map(role ->toRoleDto(role))
                .collect(Collectors.toList());
    }
    public static List<Role> toRoleListEntity(List<RoleDto> rolesDto ){
        return rolesDto.stream()
                .map(roleDto ->toRoleEntity(roleDto))
                .collect(Collectors.toList());
    }
}
