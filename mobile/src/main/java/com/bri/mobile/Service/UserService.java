package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.RoleMap;
import com.bri.mobile.DTO.Mapper.UserMap;

import com.bri.mobile.DTO.model.UserDto;
import com.bri.mobile.Entity.Role;
import com.bri.mobile.Entity.User;
import com.bri.mobile.Face.UserFace;
import com.bri.mobile.Repo.UserRepo;
import com.bri.mobile.tool.stat.UserRoleCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserFace {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<UserDto> getAllUsers(){

        List<User> users = userRepo.findAll();
        List<UserDto>usersDto=new ArrayList<>();
        for (User user:users){
            usersDto.add(UserMap.toUserDto(user));
        }
        return usersDto;
    }
    public UserDto getUserById(int id){
        Optional<User> userTest=userRepo.findById(id);
        if(userTest.isPresent()){
            User user=userTest.get();
            return UserMap.toUserDto(user);
        }else{
            return null;
        }
    }
    public UserDto addUser(UserDto userDto){
        User user = UserMap.toUserEntity(userDto);
        User userSaved= userRepo.save(user);
        return UserMap.toUserDto(userSaved);
    }
    public UserDto updateUser(UserDto user, int id){
        Optional<User> testUser = userRepo.findById(id);
        if(testUser.isPresent()){
            User oldUser=testUser.get();
            oldUser.setName(user.getName());
            oldUser.setLastName(user.getLastName());
            oldUser.setEmail(user.getEmail());
            oldUser.setDob(user.getDob());
            oldUser.setPassword(user.getPassword());
            oldUser.setAdress(user.getAdress());
            oldUser.setRole(RoleMap.toRoleEntity(user.getRole()));
            oldUser.setImg(user.getImg());
            oldUser.setStateUser(user.getStateUser());
            User userRes =userRepo.save(oldUser);
            return UserMap.toUserDto(userRes);
        }else{
            throw new RuntimeException("user not found");
        }
    }
    public void deleteUser(int id){
        userRepo.deleteById(id);
    }
    public UserDto updateState(int id,UserDto user){
        Optional<User> testUser=userRepo.findById(id);
        if(testUser.isPresent()){
            User oldUserEntity=testUser.get();
            UserDto oldUserDto=UserMap.toUserDto(oldUserEntity);
            oldUserDto.setStateUser(user.getStateUser());
            User userToSave = UserMap.toUserEntity(oldUserDto);
            User userRes =userRepo.save(userToSave);
            return UserMap.toUserDto(userRes);
        }else{
            System.out.println("user not found");
            return null;
        }
    }
    public UserDto updatePassword(int id,UserDto user){
        Optional<User> testUser=userRepo.findById(id);
        if(testUser.isPresent()){
            User oldUserEntity=testUser.get();
            UserDto oldUserDto=UserMap.toUserDto(oldUserEntity);
            oldUserDto.setPassword(passwordEncoder.encode(user.getPassword()));
            User userToSave = UserMap.toUserEntity(oldUserDto);
            User userRes =userRepo.save(userToSave);
            return UserMap.toUserDto(userRes);
        }else{
            System.out.println("user not found");
            return null;
        }
    }

    @Override
    public List<UserDto> getAllPartners() {
        Role role=new Role();
        role.setNameRole("partner");
        role.setIdRole(2);
        List<User> users = userRepo.findByRole(role);
        List<UserDto>usersDto=new ArrayList<>();
        for (User user:users){
            usersDto.add(UserMap.toUserDto(user));
        }
        return usersDto;
    }
    @Override
    public List<UserDto> getAllClients() {
        Role role=new Role();
        role.setNameRole("client");
        role.setIdRole(3);
        List<User> users = userRepo.findByRole(role);
        List<UserDto>usersDto=new ArrayList<>();
        for (User user:users){
            usersDto.add(UserMap.toUserDto(user));
        }
        return usersDto;
    }
    public List<UserRoleCount> countUsersByRole() {
        List<Object[]> userRoleCounts = userRepo.countUsersByRole();

        return userRoleCounts.stream()
                .map(objects -> new UserRoleCount((String) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
    }
}
