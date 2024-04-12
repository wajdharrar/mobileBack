package com.bri.mobile.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class Provider{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idProvider;
    @Column(length=10)
    private String nameRes;
    @Column(length=10)
    private String lastNameRes;
    @Column(length = 100)
    private String emailRes;
    @Column(length=8)
    private String numberRes;
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Shop> shops;
    @ManyToMany
    private List<Device> devices = new ArrayList<>();
    @Column
    private int idUser;
}
