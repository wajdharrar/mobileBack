package com.bri.mobile.analytics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/analytic")
public class GoogleAnalyticsController {
    @Autowired
    AnalyticsDataService service ;
    @GetMapping("/all")
    AnalyticsData getRepport(){
        return service.fetchDataAndProcess();
    }
    @GetMapping("event")
    List<AnalyticsData> getEvent(){
        return service.fetchEventsAndProcess();
    }
    @GetMapping("page")
    List<AnalyticsData> getPage(){
        return service.fetchPathAndProcess();
    }
    @GetMapping("buyer")
    List<AnalyticsData> getBuyer(){
        return service.fetchBuyersAndProcess();
    }
    @GetMapping("scroll")
    List<AnalyticsData> getScroller(){
        return service.fetchScrollAndProcess();
    }
}
