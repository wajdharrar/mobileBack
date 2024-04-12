package com.bri.mobile.DTO.model;

import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class UserPhoneIdDto {
    private int idUser;
    private int idPhone;
}
