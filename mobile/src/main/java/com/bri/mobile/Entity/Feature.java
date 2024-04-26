package com.bri.mobile.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

import java.util.List;


@Entity
@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFeature;
    @Column(length = 40,nullable = false)
    private String nameFeature;
    @Column(nullable = true)
    private int idDeviceType;
    @ManyToMany(mappedBy = "features")
    private List<Version> versions = new ArrayList<>();

}
