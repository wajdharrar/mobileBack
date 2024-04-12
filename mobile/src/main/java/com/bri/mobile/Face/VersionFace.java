package com.bri.mobile.Face;

import com.bri.mobile.Entity.Value;
import com.bri.mobile.Entity.Version;

import java.util.List;

public interface VersionFace {
    List<Version> getAllVersions();
    Version getVersionById(int id);
    Version addVersion(Version version);
    Version updateVersion(Version version, int id);
    void deleteVersion(int id);
}
