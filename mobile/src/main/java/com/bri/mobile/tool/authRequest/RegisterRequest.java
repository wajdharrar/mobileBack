package com.bri.mobile.tool.authRequest;

import com.bri.mobile.Entity.Role;
import com.bri.mobile.Enum.StateUser;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    private String name;
    private String lastName;
    private String number;
    private String mdp;
    private String email;
    private String adress;
    private String dob;
    private String img;
    private StateUser stateUser;
    private Role role;
}
