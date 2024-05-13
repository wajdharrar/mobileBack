package com.bri.mobile.analytics;


import lombok.Data;

@Data
public class AnalyticPageTab {
    private String dimensionValues;
    private String metricValue;
    private String eventCount;
    private String engagementRate;
    private String averageSessionDuration;

}
