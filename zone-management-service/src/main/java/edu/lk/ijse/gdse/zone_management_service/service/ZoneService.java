package edu.lk.ijse.gdse.zone_management_service.service;

import edu.lk.ijse.gdse.zone_management_service.dto.RequestZoneDTO;
import edu.lk.ijse.gdse.zone_management_service.dto.ThresholdLimitsDTO;
import edu.lk.ijse.gdse.zone_management_service.dto.ZoneDTO;

import java.util.List;

public interface ZoneService {

    ZoneDTO saveZoneWithDevice(RequestZoneDTO requestZoneDTO, String authHeader);
    ThresholdLimitsDTO getZoneThresholdLimits(String zoneId, String deviceId);
    List<ZoneDTO> getZone(String zoneId);
    String updateGivenZoneThresholds(ThresholdLimitsDTO thresholdLimitsDTO);

}
