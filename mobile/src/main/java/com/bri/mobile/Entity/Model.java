package com.bri.mobile.Entity;

import com.bri.mobile.Enum.State;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Entity
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idModel;
    @Column(length =100,nullable = false)
    private String nameModel;
    @Column(length=255000)
    private String imgModel;
    @Column(length=1000,nullable = false)
    private String descModel;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(length = 1000)
    private String reason;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Brand")
    private Brand brand;
    @OneToMany(mappedBy = "model",cascade = CascadeType.ALL)
    private List<Version> versions;
}
