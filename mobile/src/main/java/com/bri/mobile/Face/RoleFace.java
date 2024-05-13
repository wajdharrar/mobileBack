package com.bri.mobile.Face;

import com.bri.mobile.Entity.Role;

import java.util.List;

public interface RoleFace {
    List<Role> getAllRoles();
    Role getRoleById(int id);
    Role addRole(Role role);
    Role updateRole(Role role, int id);
    void deleteRole(int id);
}
