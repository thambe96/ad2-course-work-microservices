package edu.lk.ijse.gdse.auth_service.repository;

import edu.lk.ijse.gdse.auth_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
}
