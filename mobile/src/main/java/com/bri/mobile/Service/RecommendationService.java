package com.bri.mobile.Service;

import com.bri.mobile.DTO.Mapper.DeviceMap;
import com.bri.mobile.DTO.model.CartDto;
import com.bri.mobile.DTO.model.DeviceDto;
import com.bri.mobile.Entity.Device;
import com.bri.mobile.Entity.Request;
import com.bri.mobile.Entity.User;

import com.bri.mobile.Repo.DeviceRepo;
import com.bri.mobile.Repo.RequestRepo;
import com.bri.mobile.tool.stat.TopDevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RecommendationService {
    @Autowired
    RequestRepo requestRepo;
    @Autowired
    DeviceRepo deviceRepo;
    @Autowired
    CartService cartService;
    @Autowired
    DeviceService deviceService;
    public List<DeviceDto> recommendDevicesForUser(User user) {
        List<DeviceDto> oldDevices = new ArrayList<>();
        List<Request> pastRequests = requestRepo.findByUser(user);

        if (pastRequests.isEmpty()) {
            List<TopDevices> topDevices = cartService.findTopRequestedDevicesForCurrentWeek();
            List<DeviceDto> defaultList = new ArrayList<>();
            for (int i = 0; i < topDevices.size(); i++) {
                DeviceDto deviceDto = deviceService.getDeviceById(topDevices.get(i).getId());
                defaultList.add(deviceDto);
            }
            return defaultList;
        } else {
            for (Request request : pastRequests) {
                List<CartDto> oldCarts = cartService.getByIdRequest(request);
                oldDevices.addAll(oldCarts.stream().map(cartDto ->
                        deviceService.getDeviceById(cartDto.getDevice().getIdDevice())).collect(Collectors.toList()));
            }

            List<String> userPreferredDeviceTypes = oldDevices.stream()
                    .map(device -> device.getDeviceType().getNameType())
                    .toList();

            double minPrice = oldDevices.stream()
                    .mapToDouble(DeviceDto::getPrice)
                    .min()
                    .orElse(0);

            double maxPrice = oldDevices.stream()
                    .mapToDouble(DeviceDto::getPrice)
                    .max()
                    .orElse(0);

            double minPriceD = minPrice * 0.9;
            double maxPriceD = maxPrice * 1.2;

            List<Integer> requestedDeviceIds = oldDevices.stream()
                    .map(DeviceDto::getIdDevice)
                    .collect(Collectors.toList());

            PageRequest pageRequest = PageRequest.of(0, 10);
            List<Device> recommended = deviceRepo.findRecommendedDevices(userPreferredDeviceTypes, minPriceD, maxPriceD, pageRequest);

            List<Device> newRecommended = recommended.stream()
                    .filter(device -> !requestedDeviceIds.contains(device.getIdDevice()))
                    .collect(Collectors.toList());

            if (newRecommended.isEmpty()) {
                List<TopDevices> topDevices = cartService.findTopRequestedDevicesForCurrentWeek();
                List<DeviceDto> defaultList = new ArrayList<>();
                for (TopDevices topDevice : topDevices) {
                    DeviceDto deviceDto = deviceService.getDeviceById(topDevice.getId());
                    defaultList.add(deviceDto);
                }
                return defaultList;
            }
            return DeviceMap.toDeviceListDto(newRecommended);
        }
    }
}
