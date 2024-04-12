package com.bri.mobile.DTO.Mapper;

import com.bri.mobile.DTO.model.VersionDto;
import com.bri.mobile.Entity.Version;

import java.util.List;
import java.util.stream.Collectors;

public class VersionMap {
    public static VersionDto toVersionDto(Version version ){
        return VersionDto.builder()
                .idVersion(version.getIdVersion())
                .nameVersion(version.getNameVersion())
                .imgVersion(version.getImgVersion())
                .descVersion(version.getDescVersion())
                .state(version.getState())
                .reason(version.getReason())
                .model(ModelMap.toModelDto(version.getModel()))
                .build();
    }
    public static Version toVersionEntity(VersionDto versionDto ){
        return Version.builder()
                .idVersion(versionDto.getIdVersion())
                .nameVersion(versionDto.getNameVersion())
                .imgVersion(versionDto.getImgVersion())
                .descVersion(versionDto.getDescVersion())
                .state(versionDto.getState())
                .reason(versionDto.getReason())
                .model(ModelMap.toModelEntity(versionDto.getModel()))
                .build();
    }
    public static List<VersionDto> toVersionListDto(List<Version> versions){
        return versions.stream()
                .map(version ->toVersionDto(version))
                .collect(Collectors.toList());
    }
    public static List<Version> toVersionListEntity(List<VersionDto> versionsDto ){
        return versionsDto.stream()
                .map(versionDto ->toVersionEntity(versionDto))
                .collect(Collectors.toList());
    }
}
