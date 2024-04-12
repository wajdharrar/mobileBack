package com.bri.mobile.DTO.model;

import com.bri.mobile.Enum.State;
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
public class GiftDto {
    private int idGift;
    private String nameGift;
    private String imgGift;
    private State state;
    private String reason;
    private List<DeviceDto> devices = new ArrayList<>();
}
