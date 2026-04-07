package edu.lk.ijse.gdse.zone_management_service.service;

import edu.lk.ijse.gdse.zone_management_service.dto.RequestZoneDTO;
import edu.lk.ijse.gdse.zone_management_service.dto.ZoneDTO;

public interface ZoneService {

    ZoneDTO saveZoneWithDevice(RequestZoneDTO requestZoneDTO, String authHeader);

}
