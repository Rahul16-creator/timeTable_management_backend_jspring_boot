package com.time_table_management_system.time_table_management_system.repository;

import com.time_table_management_system.time_table_management_system.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Dept,Integer> {
    Dept findByCode(String code);

}
