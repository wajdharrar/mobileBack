package com.bri.mobile.DTO.model;

import com.bri.mobile.Entity.Document;
import com.bri.mobile.Entity.User;
import com.bri.mobile.Enum.BorrowerType;
import com.bri.mobile.Enum.State;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private int idRequest;
    private Date date;
    private float initialPayment;
    private int warranty;
    private int repayement;
    private State state;
    private String reason;
    private UserDto user;
}