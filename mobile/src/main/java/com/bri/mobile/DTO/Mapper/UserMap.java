package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.GiftDto;
import com.bri.mobile.DTO.model.UserDto;
import com.bri.mobile.Entity.Gift;
import com.bri.mobile.Entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMap {
    public static UserDto toUserDto(User user){
        return UserDto.builder()
                .idUtilisateur(user.getIdUtilisateur())
                .name(user.getName())
                .lastName(user.getLastName())
                .number(user.getNumber())
                .password(user.getPassword())
                .email(user.getEmail())
                .adress(user.getAdress())
                .dob(user.getDob())
                .img(user.getImg())
                .stateUser(user.getStateUser())
                .role(RoleMap.toRoleDto(user.getRole()))
                .build();
    }
    public static User toUserEntity(UserDto userDto){
        return User.builder()
                .idUtilisateur(userDto.getIdUtilisateur())
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .number(userDto.getNumber())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .adress(userDto.getAdress())
                .dob(userDto.getDob())
                .img(userDto.getImg())
                .stateUser(userDto.getStateUser())
                .role(RoleMap.toRoleEntity(userDto.getRole()))
                .build();
    }
    public static List<UserDto> toUserListDto(List<User> users){
        return users.stream()
                .map(user ->toUserDto(user))
                .collect(Collectors.toList());
    }
    public static List<User> toUserListEntity(List<UserDto> usersDto ){
        return usersDto.stream()
                .map(userDto ->toUserEntity(userDto))
                .collect(Collectors.toList());
    }
}
