package com.bri.mobile.Face;

import com.bri.mobile.Entity.Gift;
import com.bri.mobile.Entity.GiftPhoneId;

import java.util.List;

public interface GiftFace {
    List<Gift> getAllGifts();
    Gift getGiftById(int id);
    Gift addGift(Gift gift);
    Gift updateGift(Gift gift, int id);
    void deleteGift(int id);
}
