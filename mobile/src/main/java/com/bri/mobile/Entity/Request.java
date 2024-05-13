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
    private float initialPayment;
    @Column(nullable = false)
    private int warranty;
    @Column(nullable = false)
    private int repayement;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(length = 1000)
    private String reason;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "request",cascade = CascadeType.ALL)
    private List<Cart> carts;
    @OneToMany(mappedBy = "request",cascade = CascadeType.ALL)
    private List<Document> documents;
}