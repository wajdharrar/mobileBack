package com.bri.mobile.Upload;

import com.bri.mobile.Entity.*;
import com.bri.mobile.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BrandRepo brandRepo;
    @Autowired
    ModelRepo modelRepo;
    @Autowired
    VersionRepo versionRepo;
    @Autowired
    GiftRepo giftRepo;
    @Autowired
    DeviceRepo deviceRepo;
    @PostMapping("/upload/{id}/{type}")
    public ResponseEntity<?>uploadFile(@RequestBody MultipartFile file,@PathVariable("id") int entityId,@PathVariable("type") String entity){
        if(file.isEmpty()){
            return ResponseEntity.badRequest().body("plaese choose a file");
        }
        try{
            switch (entity){
                case "user":
                    Optional<User> userTest= userRepo.findById(entityId);
                    if(userTest.isPresent()){
                        User user = userTest.get();
                        user.setImg("data:image/png;base64,"+Base64.getEncoder().encodeToString(file.getBytes()));
                        userRepo.save(user);
                        break;
                    }else{
                        return ResponseEntity.badRequest().body("User Not Found");
                    }
                case "brand":
                    Optional<Brand> brandTest= brandRepo.findById(entityId);
                    if(brandTest.isPresent()){
                        Brand brand = brandTest.get();
                        brand.setLogoBrand(Base64.getEncoder().encodeToString(file.getBytes()));
                        brandRepo.save(brand);
                        break;
                    }else{
                        return ResponseEntity.badRequest().body("Brand Not Found");
                    }
                case "model":
                    Optional<Model> modelTest= modelRepo.findById(entityId);
                    if(modelTest.isPresent()){
                        Model model = modelTest.get();
                        model.setImgModel(Base64.getEncoder().encodeToString(file.getBytes()));
                        modelRepo.save(model);
                        break;
                    }else{
                        return ResponseEntity.badRequest().body("Model Not Found");
                    }
                case "version":
                    Optional<Version> versionTest= versionRepo.findById(entityId);
                    if(versionTest.isPresent()){
                        Version version = versionTest.get();
                        version.setImgVersion(Base64.getEncoder().encodeToString(file.getBytes()));
                        versionRepo.save(version);
                        break;
                    }else {
                        return ResponseEntity.badRequest().body("Version Not Found");
                    }
                case "gift":
                    Optional<Gift> giftTest= giftRepo.findById(entityId);
                    if(giftTest.isPresent()){
                        Gift gift = giftTest.get();
                        gift.setImgGift(Base64.getEncoder().encodeToString(file.getBytes()));
                        giftRepo.save(gift);
                        break;
                    }else {
                        return ResponseEntity.badRequest().body("Gift Not Found");
                    }
                case "device":
                    Optional<Device> deviceTest= deviceRepo.findById(entityId);
                    if(deviceTest.isPresent()){
                        Device device = deviceTest.get();
                        device.setImgDevice(Base64.getEncoder().encodeToString(file.getBytes()));
                        deviceRepo.save(device);
                        break;
                    }else {
                        return ResponseEntity.badRequest().body("Device Not Found");
                    }
                default:
                    return ResponseEntity.badRequest().body(("choose ana entity type"));
            }
            return ResponseEntity.ok().body("File uploaded successfully: " + file.getOriginalFilename());
        }catch(IOException e){
            e.printStackTrace(); // Log the error or handle it appropriately
            return ResponseEntity.status(500).body("Failed to upload the file");
        }
    }
}
