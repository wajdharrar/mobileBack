package com.bri.mobile.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idValue;
    @Column(length=100,nullable = false)
    private String Value;
    @Column(length=10,nullable = false)
    private String unit;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idFeature")
    private Feature feature;
}