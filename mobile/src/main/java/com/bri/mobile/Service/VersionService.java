package com.bri.mobile.Service;


import com.bri.mobile.DTO.Mapper.VersionMap;

import com.bri.mobile.DTO.model.VersionDto;
import com.bri.mobile.Entity.Model;
import com.bri.mobile.Entity.Version;
import com.bri.mobile.Enum.State;
import com.bri.mobile.Face.VersionFace;
import com.bri.mobile.Repo.VersionRepo;
import com.bri.mobile.tool.stat.EntityStateCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VersionService implements VersionFace {
    @Autowired
    VersionRepo versionRepo;
    @Override
    public List<VersionDto> getAllVersions(){
        return VersionMap.toVersionListDto(versionRepo.findAll());
    }
    @Override
    public List<VersionDto> getAllVersionsByIdPartners(int idPartner){
        return VersionMap.toVersionListDto(versionRepo.findByPartnerId(idPartner));
    }
    @Override
    public VersionDto getVersionById(int id){
        Optional<Version> testVersion = versionRepo.findById(id);
        if(testVersion.isPresent()){
            return VersionMap.toVersionDto(testVersion.get());
        }else {
            throw new RuntimeException("version not found");
        }
    }
    @Override
    public VersionDto addVersion(VersionDto versionDto){
        return VersionMap.toVersionDto(versionRepo.save(VersionMap.toVersionEntity(versionDto)));
    }
    @Override
    public VersionDto updateVersion(VersionDto model, int id){
        Optional<Version> testVersion = versionRepo.findById(id);
        if(testVersion.isPresent()){
            Version oldVersion=testVersion.get();
            oldVersion.setNameVersion(model.getNameVersion());
            oldVersion.setImgVersion(model.getImgVersion());
            oldVersion.setDescVersion(model.getDescVersion());
            return VersionMap.toVersionDto(versionRepo.save(oldVersion));
        }else{
            throw new RuntimeException("version not found");
        }
    }
    @Override
    public void deleteVersion(int id){
        versionRepo.deleteById(id);
    }
    public VersionDto updateState(VersionDto versionState, int id){
        Optional<Version> testVersion = versionRepo.findById(id);
        if(testVersion.isPresent()){
            Version oldVersion=testVersion.get();
            oldVersion.setState(versionState.getState());
            return VersionMap.toVersionDto(versionRepo.save(oldVersion));
        }else{
            throw new RuntimeException("version not found");
        }
    }
    public List<VersionDto> getVersionByModel(Model model){
        return VersionMap.toVersionListDto(versionRepo.findByModel(model));
    }
    public Integer getAllPartnersId(int idVersion){
        return versionRepo.findIdPartners(idVersion);
    }
    public List<EntityStateCount>countVersionsByState(Long id){
        List<Object[]> versionCount=versionRepo.countVersionsByState(id);
        return versionCount.stream()
                .map(objects -> new EntityStateCount((State) objects[0],(Long) objects[1]))
                .collect(Collectors.toList());
    }
}
