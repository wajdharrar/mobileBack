package com.bri.mobile.analytics;

import com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient;
import com.google.analytics.data.v1alpha.AlphaAnalyticsDataSettings;
import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.BetaAnalyticsDataSettings;
import com.google.api.gax.core.CredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;


import java.io.FileInputStream;
import java.io.IOException;
@Service
public class GoogleAnalyticsService {

    public BetaAnalyticsDataClient initializeAnalyticsClient() throws IOException {
        // Load the service account credentials JSON file
        GoogleCredentials credentials = ServiceAccountCredentials.fromStream(new FileInputStream("C:/Users/wajdh/Downloads/mobile/mobile/src/main/resources/credentials.json"));

        // Create settings for the client
        BetaAnalyticsDataSettings settings = BetaAnalyticsDataSettings.newBuilder()
                .setCredentialsProvider(() -> credentials)
                .build();

        // Create and return an instance of the client
        return BetaAnalyticsDataClient.create(settings);
    }
}
