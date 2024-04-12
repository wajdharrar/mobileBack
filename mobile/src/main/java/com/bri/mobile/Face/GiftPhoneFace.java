package com.bri.mobile.Face;

import com.bri.mobile.Entity.GiftPhone;
import com.bri.mobile.Entity.GiftPhoneId;

import java.util.List;

public interface GiftPhoneFace {
    List<GiftPhone> getAllGiftPhones();
    GiftPhone getGiftPhoneById(int id);
    GiftPhone addGiftPhone(GiftPhone giftPhone);
    GiftPhone updateGiftPhone(GiftPhone giftPhone, int id);
    void deleteGiftPhone(int id);
}
