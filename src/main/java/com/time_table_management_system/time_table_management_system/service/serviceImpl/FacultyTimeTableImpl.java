package com.time_table_management_system.time_table_management_system.service.serviceImpl;

import com.time_table_management_system.time_table_management_system.entity.ClassTimeTable;
import com.time_table_management_system.time_table_management_system.entity.FacultyTimeTable;
import com.time_table_management_system.time_table_management_system.repository.FacultyTimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyTimeTableImpl {

    @Autowired
    private FacultyTimeTableRepository facultyTimeTableRepository;

    public boolean generateFacultyTimeTable(String name, String email) {
        try {
            FacultyTimeTable timeTable = new FacultyTimeTable();
            timeTable.setEmail(email);
            timeTable.setName(name);
            facultyTimeTableRepository.save(timeTable);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }


    public boolean deleteFacultyTimeTable(String email) throws Exception {
        FacultyTimeTable res = facultyTimeTableRepository.findByEmail(email);
        if (res == null) {
            throw new Exception("Invalid Email Id");
        }
        try {
            facultyTimeTableRepository.deleteById(res.getId());
        } catch (Exception ex) {
            return false;
        }
        return true;
    }


    public FacultyTimeTable getTimeTable(String email) throws Exception {
        FacultyTimeTable res= facultyTimeTableRepository.findByEmail(email);
        if(res==null){
            throw new Exception("Time table for this faculty is not generated");
        }
        return res;
    }






}
