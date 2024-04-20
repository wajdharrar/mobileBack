package com.bri.mobile.Entity;

import com.bri.mobile.Enum.State;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idBrand;
    @Column(length = 10,nullable = false)
    private String nameBrand;
    @Column(length=255000,nullable = false)
    private String logoBrand;
    @Column(length = 1000, nullable = false)
    private String descBrand;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(length = 1000)
    String reason;
    @OneToMany(mappedBy = "brand" ,cascade = CascadeType.ALL)
    private List<Device> devices;
    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
    private List <Model> models;

    @Entity
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name="sale")
    public static class Sale {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int idSale;
        @Column
        private float value;
        @Column
        private String startDate;
        @Column
        private String endDate;
        @Enumerated(EnumType.STRING)
        private State state;
        @Column(length = 1000)
        private String reason;
        @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
        private List<Device> devices;
    }
}
