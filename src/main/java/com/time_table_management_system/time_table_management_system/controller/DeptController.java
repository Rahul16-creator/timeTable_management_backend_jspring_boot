package com.time_table_management_system.time_table_management_system.controller;

import com.time_table_management_system.time_table_management_system.ResponseModel.SuccessMessage;
import com.time_table_management_system.time_table_management_system.entity.Course;
import com.time_table_management_system.time_table_management_system.entity.Dept;
import com.time_table_management_system.time_table_management_system.service.CourseService;
import com.time_table_management_system.time_table_management_system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping(value = "/addDept",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addCourse(@RequestBody Dept data) throws Exception {
        deptService.addDept(data);
        SuccessMessage res = new SuccessMessage("Data added Succcessfully", "Dept added Succcessfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @PostMapping(value = "/deleteDept",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteCourse(@RequestBody Dept data) throws Exception {
        deptService.deleteDept(data);
        SuccessMessage res = new SuccessMessage("Data deleted Succcessfully", "Dept deleted Succcessfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
