package com.time_table_management_system.time_table_management_system.repository;

import com.time_table_management_system.time_table_management_system.entity.ClassSlot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassSlotRepository extends JpaRepository<ClassSlot,Integer>{
    
}
