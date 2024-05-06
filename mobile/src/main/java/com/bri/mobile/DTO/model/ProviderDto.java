package com.bri.mobile.DTO.model;



import lombok.*;



@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDto {
    private int idProvider;
    private String nameRes;
    private String lastNameRes;
    private String emailRes;
    private String numberRes;
    private int idUser;
}
