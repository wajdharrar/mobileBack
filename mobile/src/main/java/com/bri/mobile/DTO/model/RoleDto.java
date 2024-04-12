package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private int idRole;
    private String nameRole;
}
