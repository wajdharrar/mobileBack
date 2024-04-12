package com.bri.mobile.Entity;

import com.bri.mobile.Enum.State;
import com.bri.mobile.Enum.BorrowerType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRequest;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private float equity;
    @Column(nullable = false)
    private int repayement;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(length = 1000)
    private String reason;
    @Enumerated(EnumType.STRING)
    private BorrowerType borowerType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;
    @OneToMany(mappedBy = "request",cascade = CascadeType.ALL)
    private List<Document> documents;
}
