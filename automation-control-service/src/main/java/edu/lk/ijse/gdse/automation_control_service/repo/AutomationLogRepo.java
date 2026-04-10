package edu.lk.ijse.gdse.automation_control_service.repo;

import edu.lk.ijse.gdse.automation_control_service.entity.AutomationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomationLogRepo extends JpaRepository<AutomationLog, String> {
}
