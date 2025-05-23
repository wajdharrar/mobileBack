package com.bri.mobile.cntroller;



import com.bri.mobile.DTO.model.VersionDto;
import com.bri.mobile.Entity.Model;

import com.bri.mobile.Face.VersionFace;
import com.bri.mobile.tool.stat.EntityStateCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/version")
public class VersionController {
    @Autowired
    VersionFace versionFace;
    @GetMapping("/all")
    List<VersionDto> getAllVersions(){
            return versionFace.getAllVersions();
        }
    @GetMapping("/all/{idPartner}")
    List<VersionDto> getAllVersionsByPartner(@PathVariable int idPartner){
        return versionFace.getAllVersionsByIdPartners(idPartner);
    }
    @GetMapping("/idPartners/{idVersion}")
    Integer getAllIdPartners(@PathVariable int idVersion){
        return versionFace.getAllPartnersId(idVersion);
    }

    @PostMapping("/add")
    VersionDto addVersion(@RequestBody VersionDto version){
            return  versionFace.addVersion(version);
        }
    @PostMapping("/all/model")
    List<VersionDto> getVersionByModel(@RequestBody Model model){
        return  versionFace.getVersionByModel(model);
    }
    @GetMapping("/{id}")
    VersionDto getVersionById(@PathVariable int id ){
            return versionFace.getVersionById(id);
        }
    @PutMapping("/update/{id}")
    VersionDto updateVersion(@PathVariable int id ,@RequestBody VersionDto version){
        return versionFace.updateVersion(version,id);
    }
    @PutMapping("/updatestate/{id}")
    VersionDto updateState(@PathVariable int id ,@RequestBody VersionDto versionState){
        return versionFace.updateState(versionState,id);
    }
    @DeleteMapping("/delete/{id}")
    void deleteVersion(@PathVariable int id){
            versionFace.deleteVersion(id);
        }
    @GetMapping("/count/state/{id}")
    List<EntityStateCount>countVersionsByState(@PathVariable Long id){
        return versionFace.countVersionsByState(id);
    }
}
