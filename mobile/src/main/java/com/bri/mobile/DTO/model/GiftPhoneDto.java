package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.GiftPhoneId;
import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class GiftPhoneDto {
    private GiftPhoneId idGifitPhone;
}
