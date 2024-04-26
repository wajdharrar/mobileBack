package com.bri.mobile.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FeatureVersion {
    @EmbeddedId
    private FeatureVersionId idFeatureVersion;
    @Column
    private String value;
}
