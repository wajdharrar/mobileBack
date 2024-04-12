package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.Request;
import com.bri.mobile.Enum.State;
import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto {
    private int idDocument;
    private String nationalId;
    private String birthCertificate;
    private String proofOfIncome;
    private String proofOfEmployement;
    private String taxReturn;
    private String bankStatement;
    private State state;
    private String reason;
    private RequestDto request;
}
