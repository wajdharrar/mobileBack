package com.bri.mobile.analytics;

import com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient;
import com.google.analytics.data.v1beta.DateRange;
import com.google.analytics.data.v1beta.*;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AnalyticsDataService {
    private final GoogleAnalyticsService analyticsService;
    private final String propertyId = "433393126";


    public AnalyticsDataService(GoogleAnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }


    public AnalyticsData fetchDataAndProcess() {
        AnalyticsData customData = new AnalyticsData();
        try {
            // Initialize the Google Analytics client
            try (BetaAnalyticsDataClient analyticsClient = analyticsService.initializeAnalyticsClient();) {

                RunReportRequest request =
                        RunReportRequest.newBuilder()
                                .setProperty("properties/" + propertyId)
                                .addDimensions(Dimension.newBuilder().setName("country"))
                                .addMetrics(Metric.newBuilder().setName("activeUsers"))
                                .addDateRanges(DateRange.newBuilder().setStartDate("2024-03-24").setEndDate("2024-03-25"))
                                .build();
                // Make the request.
                RunReportResponse response = analyticsClient.runReport(request);

                // Iterate through every row of the API response.
                for (Row row : response.getRowsList()) {
                    customData.setDimensionValues(row.getDimensionValues(0).getValue());
                    customData.setMetricValue(row.getMetricValues(0).getValue());
                }

                analyticsClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customData;
    }
    public List<AnalyticsData> fetchEventsAndProcess() {
        List<AnalyticsData> customData = new ArrayList<>();
        try {
            // Initialize the Google Analytics client
            try (BetaAnalyticsDataClient analyticsClient = analyticsService.initializeAnalyticsClient();) {

                RunReportRequest request =
                        RunReportRequest.newBuilder()
                                .setProperty("properties/" + propertyId)
                                .addDimensions(Dimension.newBuilder().setName("eventName"))
                                .addMetrics(Metric.newBuilder().setName("eventCount"))
                                .addDateRanges(DateRange.newBuilder().setStartDate("2024-03-24").setEndDate("2024-03-25"))
                                .build();
                RunReportResponse response = analyticsClient.runReport(request);
                for (Row row : response.getRowsList()) {
                    AnalyticsData rowData=new AnalyticsData();
                    rowData.setDimensionValues(row.getDimensionValues(0).getValue());
                    rowData.setMetricValue(row.getMetricValues(0).getValue());
                    customData.add(rowData);
                }

                analyticsClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customData;
    }
    public List<AnalyticsData> fetchPathAndProcess() {
        List<AnalyticsData> customData = new ArrayList<>();
        try {
            // Initialize the Google Analytics client
            try (BetaAnalyticsDataClient analyticsClient = analyticsService.initializeAnalyticsClient();) {

                RunReportRequest request =
                        RunReportRequest.newBuilder()
                                .setProperty("properties/" + propertyId)
                                .addDimensions(Dimension.newBuilder().setName("pagePath"))
                                .addMetrics(Metric.newBuilder().setName("eventCount"))
                                .addDateRanges(DateRange.newBuilder().setStartDate("2024-03-24").setEndDate("2024-03-25"))
                                .build();
                RunReportResponse response = analyticsClient.runReport(request);
                System.out.println("page");
                for (Row row : response.getRowsList()) {
                    AnalyticsData rowData=new AnalyticsData();
                    rowData.setDimensionValues(row.getDimensionValues(0).getValue());
                    rowData.setMetricValue(row.getMetricValues(0).getValue());
                    customData.add(rowData);
                }

                analyticsClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customData;
    }
    public List<AnalyticsData> fetchBuyersAndProcess() {
        List<AnalyticsData> customData = new ArrayList<>();
        try {
            // Initialize the Google Analytics client
            try (BetaAnalyticsDataClient analyticsClient = analyticsService.initializeAnalyticsClient();) {

                RunReportRequest request =
                        RunReportRequest.newBuilder()
                                .setProperty("properties/" + propertyId)
                                .addDimensions(Dimension.newBuilder().setName("city"))
                                .addMetrics(Metric.newBuilder().setName("sessions"))
                                .addDateRanges(DateRange.newBuilder().setStartDate("2024-03-24").setEndDate("2024-03-25"))
                                .build();
                RunReportResponse response = analyticsClient.runReport(request);
                for (Row row : response.getRowsList()) {
                    AnalyticsData rowData=new AnalyticsData();
                    rowData.setDimensionValues(row.getDimensionValues(0).getValue());
                    rowData.setMetricValue(row.getMetricValues(0).getValue());
                    customData.add(rowData);
                }

                analyticsClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customData;
    }
    public List<AnalyticsData> fetchScrollAndProcess() {
        List<AnalyticsData> customData = new ArrayList<>();
        try {
            // Initialize the Google Analytics client
            try (BetaAnalyticsDataClient analyticsClient = analyticsService.initializeAnalyticsClient();) {

                RunReportRequest request =
                        RunReportRequest.newBuilder()
                                .setProperty("properties/" + propertyId)
                                .addDimensions(Dimension.newBuilder().setName("pagePath"))
                                .addMetrics(Metric.newBuilder().setName("scrolledUsers"))
                                .addDateRanges(DateRange.newBuilder().setStartDate("2024-03-24").setEndDate("2024-03-25"))
                                .build();
                RunReportResponse response = analyticsClient.runReport(request);
                System.out.println("page");
                for (Row row : response.getRowsList()) {
                    AnalyticsData rowData=new AnalyticsData();
                    rowData.setDimensionValues(row.getDimensionValues(0).getValue());
                    rowData.setMetricValue(row.getMetricValues(0).getValue());
                    customData.add(rowData);
                    System.out.printf(
                            "%s, %s%n", row.getDimensionValues(0).getValue(), row.getMetricValues(0).getValue());
                }

                analyticsClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customData;
    }
}
