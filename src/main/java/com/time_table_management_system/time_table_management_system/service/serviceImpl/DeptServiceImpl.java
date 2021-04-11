package com.time_table_management_system.time_table_management_system.service.serviceImpl;

import com.time_table_management_system.time_table_management_system.entity.Dept;
import com.time_table_management_system.time_table_management_system.repository.DeptRepository;
import com.time_table_management_system.time_table_management_system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {


    @Autowired
    private DeptRepository deptRepository;

    @Override
    public Dept addDept(Dept data) throws Exception {
        Dept res = deptRepository.findByCode(data.getCode());
        if (res != null) {
            throw new Exception("Dept Code already exist");
        }
        return deptRepository.save(data);
    }

    @Override
    public Dept deleteDept(Dept data) throws Exception {
        Dept response = deptRepository.findByCode(data.getCode());
        if (response == null) {
            throw new Exception("Dept code Not Exist");
        }
        deptRepository.deleteById(response.getId());
        return response;
    }
}
