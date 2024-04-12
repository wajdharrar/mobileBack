package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.Brand;
import com.bri.mobile.Entity.Version;
import com.bri.mobile.Enum.State;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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
    private List<VersionDto> versions;
}
