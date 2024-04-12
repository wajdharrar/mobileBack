package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.Feature;
import com.bri.mobile.Enum.State;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class ValueDto {
    private int idValue;
    private String valValeu;
    private String unit;
    private State state;
    private String reason;
    private Feature feature;
}
