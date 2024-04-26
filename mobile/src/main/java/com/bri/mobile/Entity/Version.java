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
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVersion;
    @Column(length =100,nullable = false)
    private String nameVersion;
    @Column(length=255000)
    private String imgVersion;
    @Column(length=1000,nullable = false)
    private String descVersion;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(length = 1000)
    private String reason;
    @ManyToMany
    @JoinTable(
            name = "featureVersion",
            joinColumns = @JoinColumn(name = "idVersion"),
            inverseJoinColumns = @JoinColumn(name = "idFeature")
    )
    private List<Feature> features = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_model")
    private Model model;

    @OneToMany(mappedBy = "version",cascade = CascadeType.ALL)
    private List<Device> devices;
}
