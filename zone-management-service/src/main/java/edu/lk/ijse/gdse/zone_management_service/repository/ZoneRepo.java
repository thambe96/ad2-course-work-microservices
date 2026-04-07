package edu.lk.ijse.gdse.zone_management_service.repository;

import edu.lk.ijse.gdse.zone_management_service.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepo extends JpaRepository<Zone, String> {
}
