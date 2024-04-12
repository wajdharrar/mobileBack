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
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFeature;
    @Column(length = 40,nullable = false)
    private String nameFeature;

    @ManyToMany
    private List<Version> versions = new ArrayList<>();
    @OneToMany(mappedBy = "feature", cascade = CascadeType.ALL)
    private List<Value> values;
}
