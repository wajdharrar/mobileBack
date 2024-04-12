package com.bri.mobile.DTO.model;

import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class GiftPhoneIdDto {
    private int idPhone;
    private int idGift;
}
