package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.Provider;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto {
    private int idShop;
    private String address;
    private String email;
    private String number;
    private String fax;
    private String facebook;
    private String instagram;
    private ProviderDto provider;
}
