package com.bri.mobile.DTO.model;


import com.bri.mobile.Enum.State;

import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class VersionDto {
    private int idVersion;
    private String nameVersion;
    private String imgVersion;
    private String descVersion;
    private State state;
    private String reason;
    private ModelDto model;
}
