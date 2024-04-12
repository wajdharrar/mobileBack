package com.bri.mobile.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idShop;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String number;
    @Column
    private String fax;
    @Column
    private String facebook;
    @Column
    private String instagram;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProvider")
    private Provider provider;
}
