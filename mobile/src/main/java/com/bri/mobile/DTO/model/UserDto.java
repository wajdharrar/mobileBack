package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.Request;
import com.bri.mobile.Entity.Role;
import com.bri.mobile.Enum.StateUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private int idUtilisateur;
    private String name;
    private String lastName;
    private String number;
    private String password;
    private String email;
    private String adress;
    private String dob;
    private String img;
    private StateUser stateUser;
    private RoleDto role;
    private List<DeviceDto> devices = new ArrayList<>();
}
