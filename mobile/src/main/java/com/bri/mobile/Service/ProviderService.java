package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.ProviderMap;
import com.bri.mobile.DTO.model.ProviderDto;
import com.bri.mobile.Entity.Provider;
import com.bri.mobile.Face.ProviderFace;
import com.bri.mobile.Repo.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService implements ProviderFace {
    @Autowired
    ProviderRepo providerRepo;
    public List<ProviderDto> getAllProviders(){return null;}
    public ProviderDto getProviderByIdUser(int id){
        return ProviderMap.toProviderdto(providerRepo.findByIdUser(id));
    }
    public ProviderDto addProvider(ProviderDto providerDto){
        Provider provider= ProviderMap.toProviderEntity(providerDto);
        return ProviderMap.toProviderdto(providerRepo.save(provider));
    }
    public ProviderDto updateProvider(ProviderDto provider, int id){
        Provider oldProvider= providerRepo.findByIdUser(id);
        if(oldProvider!=null){
            oldProvider.setNameRes(provider.getNameRes());
            oldProvider.setLastNameRes(provider.getLastNameRes());
            oldProvider.setNumberRes(provider.getNumberRes());
            oldProvider.setEmailRes(provider.getEmailRes());
            return ProviderMap.toProviderdto(providerRepo.save(oldProvider));
        }else {
            throw new RuntimeException("user not found");
        }
    }
    public void deleteProvider(int id){
        Provider provider=providerRepo.findByIdUser(id);
        providerRepo.delete(provider);
    }
}
