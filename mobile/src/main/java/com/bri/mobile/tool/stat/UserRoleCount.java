package com.bri.mobile.tool.stat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRoleCount {
    private String role;
    private Long userCount;
}
