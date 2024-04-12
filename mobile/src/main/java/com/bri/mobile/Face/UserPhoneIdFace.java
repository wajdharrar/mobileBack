package com.bri.mobile.Face;

import com.bri.mobile.Entity.UserPhoneId;

import java.util.List;

public interface UserPhoneIdFace {
    List<UserPhoneId> getAllUserPhoneIds();
    UserPhoneId getUserPhoneIdById(int id);
    UserPhoneId addUserPhoneId(UserPhoneId userPhoneId);
    UserPhoneId updateUserPhoneId(UserPhoneId userPhoneId, int id);
    void deleteUserPhoneId(int id);
}
