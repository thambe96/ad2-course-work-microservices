package edu.lk.ijse.gdse.zone_management_service.service.impl;

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


    @Override
    public ZoneDTO saveZoneWithDevice(RequestZoneDTO requestZoneDTO) {

        // send device name and zoneId to Iot Server
        ZoneRegDTO zoneRegDTO = new ZoneRegDTO(
                requestZoneDTO.getName(),
                requestZoneDTO.getZoneId()
        );





        return zoneRepo.save(zone);
    }
}
