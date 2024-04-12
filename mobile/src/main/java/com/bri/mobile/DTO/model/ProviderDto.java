package com.bri.mobile.DTO.model;


import com.bri.mobile.Entity.Shop;
import com.bri.mobile.Entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDto {
    private int idProvider;
    private String nameRes;
    private String lastNameRes;
    private String emailRes;
    private String numberRes;
    private List<DeviceDto> devices = new ArrayList<>();
    private User user;
}
