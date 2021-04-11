package com.time_table_management_system.time_table_management_system.controller;

import com.time_table_management_system.time_table_management_system.ResponseModel.SuccessMessage;
import com.time_table_management_system.time_table_management_system.entity.Course;
import com.time_table_management_system.time_table_management_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/addCourse",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_HOD') ")
    public ResponseEntity<?> addCourse(@RequestBody Course data) throws Exception {
        courseService.addCourse(data);
        SuccessMessage res = new SuccessMessage("Data added Succcessfully", "Course Data added Succcessfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @PostMapping(value = "/deleteCourse",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_HOD') ")
    public ResponseEntity<?> deleteCourse(@RequestBody Course data) throws Exception {
        courseService.deleteCourse(data);
        SuccessMessage res = new SuccessMessage("Data deleted Succcessfully", "Course Data deleted Succcessfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
