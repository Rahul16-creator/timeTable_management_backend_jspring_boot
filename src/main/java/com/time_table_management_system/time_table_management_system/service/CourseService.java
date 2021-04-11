package com.time_table_management_system.time_table_management_system.service;

import com.time_table_management_system.time_table_management_system.entity.Course;

public interface CourseService {

    Course addCourse(Course data) throws Exception;

    Course deleteCourse(Course data) throws Exception;

}
