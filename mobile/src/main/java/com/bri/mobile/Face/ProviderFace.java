package com.bri.mobile.Face;

import com.bri.mobile.DTO.model.ProviderDto;


import java.util.List;


public interface ProviderFace {
    List<ProviderDto> getAllProviders();
    ProviderDto getProviderByIdUser(int id);
    ProviderDto addProvider(ProviderDto provider);
    ProviderDto updateProvider(ProviderDto provider, int id);
    void deleteProvider(int id);
}
