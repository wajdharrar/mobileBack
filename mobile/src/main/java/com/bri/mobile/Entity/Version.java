package com.bri.mobile.Entity;

import com.bri.mobile.Enum.State;
import jakarta.persistence.*;
import lombok.*;




@Entity
@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVersion;
    @Column(length =10,nullable = false)
    private String nameVersion;
    @Column(length=255000)
    private String imgVersion;
    @Column(length=1000,nullable = false)
    private String descVersion;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(length = 1000)
    private String reason;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_model")
    private Model model;

}
