package com.time_table_management_system.time_table_management_system.service.serviceImpl;

import com.time_table_management_system.time_table_management_system.entity.Course;
import com.time_table_management_system.time_table_management_system.entity.Faculty;
import com.time_table_management_system.time_table_management_system.repository.CourseRepository;
import com.time_table_management_system.time_table_management_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseImpl implements CourseService {


    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Course addCourse(Course data) throws Exception {
        Course res = courseRepository.findByCode(data.getCode());
        if (res != null) {
            throw new Exception("Course Code already exist");
        }
        return courseRepository.save(data);
    }

    @Override
    public Course deleteCourse(Course data) throws Exception {
        Course response = courseRepository.findByCode(data.getCode());
        if (response == null) {
            throw new Exception("Course code Not Exist");
        }
        courseRepository.deleteById(response.getId());
        return response;
    }
}
