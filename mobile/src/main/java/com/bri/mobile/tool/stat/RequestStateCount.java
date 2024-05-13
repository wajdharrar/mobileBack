package com.bri.mobile.tool.stat;

import com.bri.mobile.Enum.State;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestStateCount {
    private State state;
    private Long requestCount;
}
