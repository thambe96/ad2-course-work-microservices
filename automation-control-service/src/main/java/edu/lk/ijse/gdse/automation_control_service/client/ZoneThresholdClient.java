package edu.lk.ijse.gdse.automation_control_service.client;

import edu.lk.ijse.gdse.automation_control_service.dto.ZoneThresholdsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "zone-thresholds-client", url = "http://localhost:8081/api/zones")
public interface ZoneThresholdClient {

    @GetMapping(value = "/get-threshold-limits")
    ZoneThresholdsDTO getZoneThresholds(
            @RequestParam("zoneId") String zoneId,
            @RequestParam("deviceId") String deviceId);

}
