package com.bri.mobile.analytics;

import com.google.analytics.data.v1beta.DimensionValue;
import lombok.Data;

import java.util.List;
@Data
public class AnalyticsData {
    private String dimensionValues;
    private String metricValue;
}
