package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.Value;
import com.bri.mobile.Entity.Version;
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
public class FeatureDto {
    private int idFeature;
    private String nameFeature;
    private List<VersionDto> versions = new ArrayList<>();
    private List<ValueDto> values;

}
