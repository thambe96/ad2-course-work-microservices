package edu.lk.ijse.gdse.zone_management_service.service.impl;

import edu.lk.ijse.gdse.zone_management_service.client.IoTServerClient;
import edu.lk.ijse.gdse.zone_management_service.dto.*;
import edu.lk.ijse.gdse.zone_management_service.entity.Zone;
import edu.lk.ijse.gdse.zone_management_service.repository.ZoneRepo;
import edu.lk.ijse.gdse.zone_management_service.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


//        for (Object obj : threshHoldLimits) {
//            Object[] row = (Object[]) obj;
//
//            System.out.println(Arrays.toString(row));
//        }

        Object obj = threshHoldLimits[0];
        Object[] row = (Object[]) obj;


        double maxTemp = row[1] != null ? (Double) row[1] : 0.0;
        double minTemp = row[2] != null ? (Double) row[2] : 0.0;

        System.out.println("---------------------------------------------");
        System.out.println("Min Temp: " + minTemp);
        System.out.println("Max Temp: " + maxTemp);
        System.out.println("ZoneId: " + (String) row[0]);
        System.out.println("---------------------------------------------");

        return new ThresholdLimitsDTO(
                (String) row[0],
                maxTemp,
                minTemp

        );
    }

    public List<ZoneDTO> getZone(String zoneId) {


        List<Zone> zone = zoneRepo.findByZoneId(zoneId);
        if (zone == null) {
            return null;
        }

        List<ZoneDTO> zoneDTOList = new ArrayList<>();
        for (Zone z : zone) {
            ZoneDTO zoneDTO = modelMapper.map(z, ZoneDTO.class);
            zoneDTOList.add(zoneDTO);
        }

        return zoneDTOList;
    }

    public String updateGivenZoneThresholds(ThresholdLimitsDTO thresholdLimitsDTO) {
        int effectedRows = zoneRepo.updateTempsByZoneId(
                thresholdLimitsDTO.getZoneId(),
                thresholdLimitsDTO.getMaxTemp(),
                thresholdLimitsDTO.getMinTemp());
        return effectedRows > 0 ? "Update Success" : "Update Failed";
    }






}
