package com.bri.mobile.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GiftPhone {
    @EmbeddedId
    private GiftPhoneId idGifitPhone;
}
