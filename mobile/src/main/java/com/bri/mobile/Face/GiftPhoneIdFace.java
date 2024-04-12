package com.bri.mobile.Face;

import com.bri.mobile.Entity.GiftPhoneId;
import com.bri.mobile.Entity.User;

import java.util.List;

public interface GiftPhoneIdFace {
    List<GiftPhoneId> getAllGiftPhoneIds();
    GiftPhoneId getGiftPhoneIdById(int id);
    GiftPhoneId addGiftPhoneId(GiftPhoneId giftPhoneId);
    GiftPhoneId updateGiftPhoneId(GiftPhoneId giftPhoneId, int id);
    void deleteGiftPhoneId(int id);
}
