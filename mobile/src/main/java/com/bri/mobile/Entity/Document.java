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
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDocument;
    @Column(length = 13981013,nullable = false)
    private String nationalId;
    @Column(length = 13981013,nullable = false)
    private String birthCertificate;
    @Column(length = 13981013,nullable = false)
    private String proofOfIncome;
    @Column(length = 13981013,nullable = false)
    private String proofOfEmployement;
    @Column(length = 13981013,nullable = false)
    private String taxReturn;
    @Column(length = 13981013,nullable = false)
    private String bankStatement;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(length = 1000)
    private String reason;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idRequest")
    private Request request;
}