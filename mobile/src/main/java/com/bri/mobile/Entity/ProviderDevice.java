package com.bri.mobile.Entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProviderDevice {
    @EmbeddedId
    private ProviderDeviceId id;
    private Date createdAt;
}