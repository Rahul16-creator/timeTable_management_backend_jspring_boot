package com.time_table_management_system.time_table_management_system.repository;

import com.time_table_management_system.time_table_management_system.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    Faculty findByEmail(String email);

    Faculty findByVerificationCode(String code);

    Faculty findByOtp(String otp);
}
