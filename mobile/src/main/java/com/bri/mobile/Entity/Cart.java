package com.bri.mobile.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @EmbeddedId
    private UserPhoneId idCart;
    @Column
    private float total;
    @Column
    private int itemNumber;

}




















