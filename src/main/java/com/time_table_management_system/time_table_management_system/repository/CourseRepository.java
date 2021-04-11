package com.time_table_management_system.time_table_management_system.repository;

import com.time_table_management_system.time_table_management_system.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByCode(String code);
}
