package com.bri.mobile.tool.stat;

import com.bri.mobile.Enum.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EntityStateCount {
    private State state;
    private Long count;
}
