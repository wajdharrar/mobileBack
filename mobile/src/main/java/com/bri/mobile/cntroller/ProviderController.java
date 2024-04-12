package com.bri.mobile.cntroller;

import com.bri.mobile.DTO.model.ProviderDto;
import com.bri.mobile.Face.ProviderFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider")
@CrossOrigin("*")
public class ProviderController {
    @Autowired
    ProviderFace providerFace;
    @GetMapping("/partner/{id}")
    ProviderDto getProviderByIdUser(@PathVariable int id){
        return providerFace.getProviderByIdUser(id);
    }
    @PostMapping("/add")
    ProviderDto addProvider(@RequestBody ProviderDto providerDto){
        return providerFace.addProvider(providerDto);
    }
    @PutMapping("/update/{id}")
    ProviderDto updateProvider(@RequestBody ProviderDto providerDto,@PathVariable int id ){
        return providerFace.updateProvider(providerDto,id);
    }
}
