package com.bri.mobile.analytics;


import com.google.analytics.data.v1beta.DateRange;
import com.google.analytics.data.v1beta.*;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

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
                                .addDateRanges(DateRange.newBuilder().setStartDate("7daysAgo").setEndDate("today"))
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
    public AnalyticsData fetchBounceRateAndProcess() {
        AnalyticsData customData = new AnalyticsData();
        try {
            // Initialize the Google Analytics client
            try (BetaAnalyticsDataClient analyticsClient = analyticsService.initializeAnalyticsClient();) {

                RunReportRequest request =
                        RunReportRequest.newBuilder()
                                .setProperty("properties/" + propertyId)
                                .addDimensions(Dimension.newBuilder().setName("country"))
                                .addMetrics(Metric.newBuilder().setName("bounceRate"))
                                .addDateRanges(DateRange.newBuilder().setStartDate("7daysAgo").setEndDate("today"))
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
                                .addDateRanges(DateRange.newBuilder().setStartDate("7daysAgo").setEndDate("today"))
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
    public List<AnalyticPageTab> fetchPathAndProcess() {
        List<AnalyticPageTab> customData = new ArrayList<>();
        try {
            // Initialize the Google Analytics client
            try (BetaAnalyticsDataClient analyticsClient = analyticsService.initializeAnalyticsClient();) {

                RunReportRequest request =
                        RunReportRequest.newBuilder()
                                .setProperty("properties/" + propertyId)
                                .addDimensions(Dimension.newBuilder().setName("pagePath"))
                                .addMetrics(Metric.newBuilder().setName("screenPageViews"))
                                .addMetrics(Metric.newBuilder().setName("eventCount"))
                                .addMetrics(Metric.newBuilder().setName("engagementRate"))
                                .addMetrics(Metric.newBuilder().setName("averageSessionDuration"))
                                .addDateRanges(DateRange.newBuilder().setStartDate("7daysAgo").setEndDate("today"))
                                .build();
                RunReportResponse response = analyticsClient.runReport(request);
                System.out.println("page");
                for (Row row : response.getRowsList()) {
                    AnalyticPageTab rowData=new AnalyticPageTab();
                    rowData.setDimensionValues(row.getDimensionValues(0).getValue());
                    rowData.setMetricValue(row.getMetricValues(0).getValue());
                    rowData.setEventCount(row.getMetricValues(1).getValue());
                    rowData.setEngagementRate(row.getMetricValues(2).getValue());
                    rowData.setAverageSessionDuration(row.getMetricValues(3).getValue());
                    customData.add(rowData);
                }

                analyticsClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customData;
    }
    public List<AnalyticsData> fetchCityAndProcess() {
        List<AnalyticsData> customData = new ArrayList<>();
        try {
            // Initialize the Google Analytics client
            try (BetaAnalyticsDataClient analyticsClient = analyticsService.initializeAnalyticsClient();) {

                RunReportRequest request =
                        RunReportRequest.newBuilder()
                                .setProperty("properties/" + propertyId)
                                .addDimensions(Dimension.newBuilder().setName("city"))
                                .addMetrics(Metric.newBuilder().setName("sessions"))
                                .addDateRanges(DateRange.newBuilder().setStartDate("7daysAgo").setEndDate("today"))
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
    public List<AnalyticCityTab> fetchCityTabAndProcess() {
        List<AnalyticCityTab> customData = new ArrayList<>();
        try {
            // Initialize the Google Analytics client
            try (BetaAnalyticsDataClient analyticsClient = analyticsService.initializeAnalyticsClient();) {

                RunReportRequest request =
                        RunReportRequest.newBuilder()
                                .setProperty("properties/" + propertyId)
                                .addDimensions(Dimension.newBuilder().setName("city"))
                                .addMetrics(Metric.newBuilder().setName("totalUsers"))
                                .addMetrics(Metric.newBuilder().setName("newUsers"))
                                .addMetrics(Metric.newBuilder().setName("engagedSessions"))
                                .addDateRanges(DateRange.newBuilder().setStartDate("7daysAgo").setEndDate("today"))
                                .build();
                RunReportResponse response = analyticsClient.runReport(request);
                System.out.println("city");
                for (Row row : response.getRowsList()) {
                    AnalyticCityTab rowData=new AnalyticCityTab();
                    rowData.setDimensionValues(row.getDimensionValues(0).getValue());
                    rowData.setMetricValue(row.getMetricValues(0).getValue());
                    rowData.setNewUsers(row.getMetricValues(1).getValue());
                    rowData.setEngagedSessions(row.getMetricValues(2).getValue());
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
    public List<AnalyticCityTime> fetchCityTimeAndProcess() {
        List<AnalyticCityTime> customData = new ArrayList<>();
        try {
            // Initialize the Google Analytics client
            try (BetaAnalyticsDataClient analyticsClient = analyticsService.initializeAnalyticsClient();) {

                RunReportRequest request =
                        RunReportRequest.newBuilder()
                                .setProperty("properties/" + propertyId)
                                .addDimensions(Dimension.newBuilder().setName("city"))
                                .addMetrics(Metric.newBuilder().setName("totalUsers"))
                                .addDimensions(Dimension.newBuilder().setName("day"))
                                .addDateRanges(DateRange.newBuilder().setStartDate("7daysAgo").setEndDate("today"))
                                .build();
                RunReportResponse response = analyticsClient.runReport(request);
                System.out.println("city time");
                for (Row row : response.getRowsList()) {
                    AnalyticCityTime rowData=new AnalyticCityTime();
                    rowData.setDimensionValues(row.getDimensionValues(0).getValue());
                    rowData.setMetricValue(row.getMetricValues(0).getValue());
                    rowData.setDate(row.getDimensionValues(1).getValue());
                    customData.add(rowData);
                    System.out.printf(
                            "%s, %s%n", row.getDimensionValues(0).getValue(), row.getMetricValues(0).getValue());
                }

                // Sort by date
                Collections.sort(customData, Comparator.comparing(AnalyticCityTime::getDate));

                analyticsClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customData;
    }
}
