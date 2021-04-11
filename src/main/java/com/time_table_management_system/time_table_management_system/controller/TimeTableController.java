package com.time_table_management_system.time_table_management_system.controller;

import com.time_table_management_system.time_table_management_system.RequestModel.FetchClassTimeTable;
import com.time_table_management_system.time_table_management_system.RequestModel.FetchFacultyTable;
import com.time_table_management_system.time_table_management_system.RequestModel.TimeTableCreation;
import com.time_table_management_system.time_table_management_system.ResponseModel.SuccessMessage;
import com.time_table_management_system.time_table_management_system.entity.ClassTimeTable;
import com.time_table_management_system.time_table_management_system.entity.FacultyTimeTable;
import com.time_table_management_system.time_table_management_system.service.TimeTableService;
import com.time_table_management_system.time_table_management_system.service.serviceImpl.FacultyTimeTableImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class TimeTableController {

    @Autowired
    private TimeTableService timeTableService;


    @Autowired
    private FacultyTimeTableImpl facultyTimeTableImpl;


    @PostMapping(value = "/createTable", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_HOD') ")
    public ResponseEntity<?> login(@RequestBody TimeTableCreation data) throws Exception {

        timeTableService.createTimeTable(data);

        SuccessMessage res = new SuccessMessage(" Table generated ", "Time Table generated successfully ");

        return new ResponseEntity<>(res, HttpStatus.OK);

    }


    @GetMapping(value = "/getClassTable/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getClassTimeTable(@PathVariable String code) throws Exception {

        ClassTimeTable res = timeTableService.getTimeTable(code);

        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    @GetMapping(value = "/getFacultyTable/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFacultyTimeTable(@PathVariable String email) throws Exception {

        FacultyTimeTable res = facultyTimeTableImpl.getTimeTable(email);

        return new ResponseEntity<>(res, HttpStatus.OK);

    }




}
