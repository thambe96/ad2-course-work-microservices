package edu.lk.ijse.gdse.crop_inventory_service.repository;

import edu.lk.ijse.gdse.crop_inventory_service.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepo extends JpaRepository<Crop, String> {

}
