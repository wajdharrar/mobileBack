package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.UserPhoneId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private UserPhoneIdDto idCart;
    private float total;
    private int itemNumber;
}
