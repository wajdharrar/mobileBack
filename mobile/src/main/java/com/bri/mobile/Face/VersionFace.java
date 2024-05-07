package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.VersionDto;
import com.bri.mobile.Entity.Model;

import java.util.List;

public interface VersionFace {
    List<VersionDto> getAllVersions();
    List<VersionDto> getVersionByModel(Model model);
    VersionDto getVersionById(int id);
    VersionDto addVersion(VersionDto version);
    VersionDto updateVersion(VersionDto version, int id);
    void deleteVersion(int id);
    VersionDto updateState(VersionDto version, int id);
    public List<VersionDto> getAllVersionsByIdPartners(int idPartner);
    public Integer getAllPartnersId(int idVersion);

}
