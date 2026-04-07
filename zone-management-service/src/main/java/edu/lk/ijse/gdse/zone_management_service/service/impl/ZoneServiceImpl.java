package edu.lk.ijse.gdse.zone_management_service.service.impl;

import edu.lk.ijse.gdse.zone_management_service.client.IoTServerClient;
import edu.lk.ijse.gdse.zone_management_service.dto.IotServerResponse;
import edu.lk.ijse.gdse.zone_management_service.dto.RequestZoneDTO;
import edu.lk.ijse.gdse.zone_management_service.dto.ZoneDTO;
import edu.lk.ijse.gdse.zone_management_service.dto.ZoneRegDTO;
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
}
