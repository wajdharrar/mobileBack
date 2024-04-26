package com.bri.mobile.DTO.model;


import com.bri.mobile.Enum.State;

import lombok.*;


@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class ModelDto {
    private int idModel;
    private String nameModel;
    private String imgModel;
    private String descModel;
    private State state;
    private String reason;
    private BrandDto brand;
}
