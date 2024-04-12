package com.bri.mobile;

import com.bri.mobile.analytics.AnalyticsDataService;
import com.bri.mobile.analytics.GoogleAnalyticsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileApplication.class, args);
	}

}
