package com.bri.mobile.Upload;

import com.bri.mobile.Entity.*;
import com.bri.mobile.Repo.*;
import com.bri.mobile.tool.mail.Success;
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
    public Success uploadFile(@RequestBody MultipartFile file, @PathVariable("id") int entityId, @PathVariable("type") String entity){
        if(file.isEmpty()){
            throw new RuntimeException("plaese choose a file");
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
                        throw  new RuntimeException("User Not Found");
                    }
                case "brand":
                    Optional<Brand> brandTest= brandRepo.findById(entityId);
                    if(brandTest.isPresent()){
                        Brand brand = brandTest.get();
                        brand.setLogoBrand("data:image/png;base64,"+Base64.getEncoder().encodeToString(file.getBytes()));
                        brandRepo.save(brand);
                        break;
                    }else{
                        throw new RuntimeException("Brand Not Found");
                    }
                case "model":
                    Optional<Model> modelTest= modelRepo.findById(entityId);
                    if(modelTest.isPresent()){
                        Model model = modelTest.get();
                        model.setImgModel("data:image/png;base64,"+Base64.getEncoder().encodeToString(file.getBytes()));
                        modelRepo.save(model);
                        break;
                    }else{
                        throw new RuntimeException("Model Not Found");
                    }
                case "version":
                    Optional<Version> versionTest= versionRepo.findById(entityId);
                    if(versionTest.isPresent()){
                        Version version = versionTest.get();
                        version.setImgVersion("data:image/png;base64,"+Base64.getEncoder().encodeToString(file.getBytes()));
                        versionRepo.save(version);
                        break;
                    }else {
                        throw new RuntimeException("Version Not Found");
                    }
                case "gift":
                    Optional<Gift> giftTest= giftRepo.findById(entityId);
                    if(giftTest.isPresent()){
                        Gift gift = giftTest.get();
                        gift.setImgGift("data:image/png;base64,"+Base64.getEncoder().encodeToString(file.getBytes()));
                        giftRepo.save(gift);
                        break;
                    }else {
                        throw new RuntimeException("Gift Not Found");
                    }
                case "device":
                    Optional<Device> deviceTest= deviceRepo.findById(entityId);
                    if(deviceTest.isPresent()){
                        Device device = deviceTest.get();
                        device.setImgDevice("data:image/png;base64,"+Base64.getEncoder().encodeToString(file.getBytes()));
                        deviceRepo.save(device);
                        break;
                    }else {
                        throw new RuntimeException("Device Not Found");
                    }
                default:
                    throw new RuntimeException("choose an entity type");
            }
            Success msg = new Success();
            msg.setMsg("file uploaded");
            return msg;
        }catch(IOException e){
            e.printStackTrace(); // Log the error or handle it appropriately
            throw new RuntimeException("Failed to upload the file");
        }
    }
}
