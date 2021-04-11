package com.time_table_management_system.time_table_management_system.service;

import com.time_table_management_system.time_table_management_system.RequestModel.TimeTableCreation;
import com.time_table_management_system.time_table_management_system.entity.ClassTimeTable;

public interface TimeTableService {

    void createTimeTable(TimeTableCreation data) throws Exception;
    ClassTimeTable getTimeTable(String code) throws Exception;

}
