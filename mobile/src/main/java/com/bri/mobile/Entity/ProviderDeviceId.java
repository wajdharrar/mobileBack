package com.bri.mobile.Entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ProviderDeviceId {
    private int idProvider;
    private int idDevice;
}
