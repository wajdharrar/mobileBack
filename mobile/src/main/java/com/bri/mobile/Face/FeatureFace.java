package com.bri.mobile.Face;

import com.bri.mobile.Entity.Feature;
import com.bri.mobile.Entity.User;

import java.util.List;

public interface FeatureFace {
    List<Feature> getAllFeatures();
    Feature getFeatureById(int id);
    Feature addFeature(Feature feature);
    Feature updateFeature(Feature feature, int id);
    void deleteFeature(int id);
}
