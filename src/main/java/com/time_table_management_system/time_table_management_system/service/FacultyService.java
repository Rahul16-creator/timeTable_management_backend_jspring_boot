package com.time_table_management_system.time_table_management_system.service;

import com.time_table_management_system.time_table_management_system.RequestModel.FacultyLogin;
import com.time_table_management_system.time_table_management_system.entity.Faculty;
import org.codehaus.jettison.json.JSONException;

public interface FacultyService {

    Faculty addFaculty(Faculty data) throws Exception;

    Faculty deleteFaculty(Faculty data) throws Exception;

    Faculty fetchByEmail(String email);

    Faculty update(Faculty data ,String email);

    Faculty checkEmailVerification(String code) throws JSONException;
}
