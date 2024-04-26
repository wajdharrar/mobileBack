package com.bri.mobile.Entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FeatureVersionId {
    private int idFeature;
    private int idVersion;
}
