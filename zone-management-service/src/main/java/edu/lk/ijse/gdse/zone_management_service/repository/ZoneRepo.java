package edu.lk.ijse.gdse.zone_management_service.repository;


import edu.lk.ijse.gdse.zone_management_service.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ZoneRepo extends JpaRepository<Zone, String> {

    @Query(value = "SELECT device_id, max_temp, min_temp FROM zone " +
            "WHERE zone_id = :zoneId AND device_id = :deviceId",
            nativeQuery = true)
    Object[] findZoneTempsNative(@Param("zoneId") String zoneId,
                                 @Param("deviceId") String deviceId);

    List<Zone> findByZoneId(String id);

    @Modifying
    @Transactional
    @Query("UPDATE Zone z SET z.minTemp = :minTemp, z.maxTemp = :maxTemp WHERE z.zoneId = :zoneId")
    int updateTempsByZoneId(@Param("zoneId") String zoneId,
                            @Param("minTemp") double minTemp,
                            @Param("maxTemp") double maxTemp);

    @Modifying
    @Transactional
    @Query("DELETE FROM Zone z WHERE z.zoneId = :zoneId")
    int deleteZoneById(@Param("zoneId") String zoneId);




}
