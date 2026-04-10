package edu.lk.ijse.gdse.zone_management_service.service.impl;

import edu.lk.ijse.gdse.zone_management_service.client.IoTServerClient;
import edu.lk.ijse.gdse.zone_management_service.dto.*;
import edu.lk.ijse.gdse.zone_management_service.entity.Zone;
import edu.lk.ijse.gdse.zone_management_service.repository.ZoneRepo;
import edu.lk.ijse.gdse.zone_management_service.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepo zoneRepo;
    private final ModelMapper modelMapper;
    private final IoTServerClient ioTServerClient;


    @Override
    public ZoneDTO saveZoneWithDevice(RequestZoneDTO requestZoneDTO, String authHeader) {

        // send device name and zoneId to Iot Server
        ZoneRegDTO zoneRegDTO = new ZoneRegDTO(
                requestZoneDTO.getName(),
                requestZoneDTO.getZoneId()
        );

        // use a try catch block here to handle exceptions
        IotServerResponse iotServerResponse =
                ioTServerClient
                .registerDeviceWithZone(
                authHeader,
                zoneRegDTO);

        Zone zone = new Zone();
        zone.setDeviceId(iotServerResponse.getDeviceId());
        zone.setName(iotServerResponse.getName());
        zone.setZoneId(iotServerResponse.getZoneId());
        zone.setMaxTemp(requestZoneDTO.getMaxTemp());
        zone.setMinTemp(requestZoneDTO.getMinTemp());
        zone.setCreatedAt(iotServerResponse.getCreateAt());
        zone.setUserId(iotServerResponse.getUserId());


        return modelMapper.map(zoneRepo.save(zone), ZoneDTO.class);
    }

    @Override
    public ThresholdLimitsDTO getZoneThresholdLimits(String zoneId, String deviceId) {

        Object[] threshHoldLimits = zoneRepo.findZoneTempsNative(zoneId, deviceId);

        if (threshHoldLimits == null) {
            return null;
        }

        double minTemp = threshHoldLimits[1] != null ? (Double) threshHoldLimits[1] : 0.0;
        double maxTemp = threshHoldLimits[2] != null ? (Double) threshHoldLimits[2] : 0.0;


        return new ThresholdLimitsDTO(
                (String) threshHoldLimits[0],
                minTemp,
                maxTemp
        );
    }
}
