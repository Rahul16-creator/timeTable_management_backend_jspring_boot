package com.time_table_management_system.time_table_management_system.repository;


import com.time_table_management_system.time_table_management_system.entity.FacultyTimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyTimeTableRepository extends JpaRepository<FacultyTimeTable, Integer> {

    FacultyTimeTable findByEmail(String email);

}