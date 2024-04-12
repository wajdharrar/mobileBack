package com.bri.mobile.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class DeviceType {
    @Id
    @Column
    private int idType;
    @Column
    private String nameType;
    @OneToMany(mappedBy = "deviceType", cascade = CascadeType.ALL)
    private List<Device> devices;
}
