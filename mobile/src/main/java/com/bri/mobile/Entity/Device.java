package com.bri.mobile.Entity;

import com.bri.mobile.Enum.State;
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
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDevice;
    @Column(length = 50 ,nullable=false)
    private String nameDevice;
    @Column
    private float price;
    @Column
    private int inventory;
    @Column(length = 255000)
    private String imgDevice;
    @Column(length=1000)
    private String descDevice;
    @Column(length=10, nullable=false)
    private String color;
    @Column
    private int warranty;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(length = 1000)
    private String reason;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSale")
    private Brand.Sale sale;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_version")
    private Version version;
    @ManyToMany
    @JoinTable(
            name = "cart",
            joinColumns = @JoinColumn(name = "idPhone"),
            inverseJoinColumns = @JoinColumn(name = "idUser")
    )
    private List<User> users = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "giftPhone",
            joinColumns = @JoinColumn(name = "idPhone"),
            inverseJoinColumns = @JoinColumn(name = "idGift")
    )
    private List<Gift> gifts = new ArrayList<>();
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn (name="idType")
    private DeviceType deviceType;

}
