package com.bri.mobile.DTO.model;

import com.bri.mobile.Enum.StateUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
