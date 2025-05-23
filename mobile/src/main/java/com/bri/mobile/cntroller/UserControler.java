package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.UserDto;
import com.bri.mobile.Face.UserFace;
import com.bri.mobile.tool.stat.UserRoleCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControler {
    @Autowired
    UserFace userFace;
    @GetMapping("/all")
    List<UserDto>getAllUsers(){
        return userFace.getAllUsers();
    }
    @GetMapping("/role")
    List<UserRoleCount>getUsersByRole(){
        return userFace.countUsersByRole();
    }
    @PostMapping("/add")
    UserDto addUser(@RequestBody UserDto user){
        return  userFace.addUser(user);
    }
    @GetMapping("/{id}")
    UserDto getUserById(@PathVariable int id ){
        return userFace.getUserById(id);
    }
    @GetMapping("/partner")
    List <UserDto> getAllPartners(){
        return userFace.getAllPartners();
    }
    @GetMapping("/client")
    List <UserDto> getAllClients(){
        return userFace.getAllClients();
    }
    @PutMapping("/update/{id}")
    UserDto updateUser(@PathVariable int id ,@RequestBody UserDto user){
        return userFace.updateUser(user,id);
    }
    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable int id){
        userFace.deleteUser(id);
    }
    @PutMapping("state/{id}")
    UserDto updateState(@PathVariable int id,@RequestBody UserDto user){ return userFace.updateState(id, user);}
    @PutMapping("password/{id}")
    UserDto updatePassword(@PathVariable int id,@RequestBody UserDto user){ return userFace.updatePassword(id, user);}
}
