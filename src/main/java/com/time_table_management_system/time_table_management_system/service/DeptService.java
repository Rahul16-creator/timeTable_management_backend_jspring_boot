package com.time_table_management_system.time_table_management_system.service;

import com.time_table_management_system.time_table_management_system.entity.Dept;

public interface DeptService {
    Dept addDept(Dept data) throws Exception;

    Dept deleteDept(Dept data) throws Exception;
}
