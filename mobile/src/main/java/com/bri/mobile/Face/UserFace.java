package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.UserDto;
import com.bri.mobile.Entity.User;
import com.bri.mobile.tool.stat.UserRoleCount;

import java.util.List;
import java.util.Optional;

public interface UserFace {
    List<UserDto> getAllUsers();
    List<UserDto>getAllPartners();
    List<UserDto> getAllClients();
    UserDto getUserById(int id);
    UserDto addUser(UserDto user);
    List<UserRoleCount> countUsersByRole();
    UserDto updateUser(UserDto user, int id);
    void deleteUser(int id);
    public UserDto updateState(int id, UserDto user);
    public UserDto updatePassword(int id,UserDto user);
}