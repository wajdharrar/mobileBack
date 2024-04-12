package com.bri.mobile.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRole;
    @Column(length = 10, nullable = false)
    private String nameRole;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;

}
