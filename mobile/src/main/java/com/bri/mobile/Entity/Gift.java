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
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idGift;
    @Column(length = 40,nullable = false)
    private String nameGift;
    @Column(length = 255000)
    private String imgGift;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(length = 1000)
    private String reason;
    @ManyToMany(mappedBy = "gifts")
    private List<Device> devices = new ArrayList<>();
}
