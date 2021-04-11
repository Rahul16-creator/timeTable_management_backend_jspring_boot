package com.time_table_management_system.time_table_management_system.controller;

import com.time_table_management_system.time_table_management_system.RequestModel.FacultyLogin;
import com.time_table_management_system.time_table_management_system.RequestModel.FetchFacultyTable;
import com.time_table_management_system.time_table_management_system.RequestModel.OtpVerification;
import com.time_table_management_system.time_table_management_system.RequestModel.SetNewPassword;
import com.time_table_management_system.time_table_management_system.ResponseModel.SuccessMessage;
import com.time_table_management_system.time_table_management_system.config.jwt.JwtProvider;
import com.time_table_management_system.time_table_management_system.entity.Faculty;
import com.time_table_management_system.time_table_management_system.entity.FacultyTimeTable;
import com.time_table_management_system.time_table_management_system.repository.FacultyRepository;
import com.time_table_management_system.time_table_management_system.service.FacultyService;
import com.time_table_management_system.time_table_management_system.service.serviceImpl.FacultyImpl;
import com.time_table_management_system.time_table_management_system.service.serviceImpl.UserDetailService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private FacultyRepository facultyRepository;


    @Autowired
    private FacultyImpl facultyImpl;

    @PostMapping(value = "/setup",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> setUp(@RequestBody Faculty data) throws Exception {
        facultyService.addFaculty(data);
        SuccessMessage res = new SuccessMessage("Data added Succcessfully", "Faculty Data added Succcessfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody FacultyLogin data) throws Exception {

        JSONObject jsonObject = new JSONObject();


        Faculty res_data = facultyRepository.findByEmail(data.getEmail());


        if (!res_data.isEnabled()) {
            return new ResponseEntity<String>(
                    facultyImpl.returnJsonString(false, "please verify the email to continue"),
                    HttpStatus.NOT_ACCEPTABLE);
        }


        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword()));
        } catch (Exception e) {
            throw new Exception("Email id or Password wrong");
        }

        Faculty user_data = facultyRepository.findByEmail(data.getEmail());


        String token = jwtProvider.createToken(data.getEmail());

        jsonObject.put("id", user_data.getId());
        jsonObject.put("image", user_data.getImage());
        jsonObject.put("mbverify", user_data.isMbverify());
        jsonObject.put("gender", user_data.getGender());
        jsonObject.put("name", user_data.getName());
        jsonObject.put("email", user_data.getEmail());
        jsonObject.put("phone", user_data.getPhoneNumber());
        jsonObject.put("role", user_data.getRole());
        jsonObject.put("token", token);

        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);

    }


    @PostMapping(value = "/addFaculty",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addFaculty(@RequestBody Faculty data) throws Exception {
        facultyService.addFaculty(data);
        SuccessMessage res = new SuccessMessage("Data added Succcessfully", "Faculty Data added Succcessfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @PostMapping(value = "/deleteFaculty",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_HOD') ")
    public ResponseEntity<?> deleteFaculty(@RequestBody Faculty data) throws Exception {
        facultyService.deleteFaculty(data);
        SuccessMessage res = new SuccessMessage("Data deleted Succcessfully", "Faculty Data deleted Succcessfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @GetMapping(value = "/fetchFaculty/{email}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> fetchFacultyByEmail(@PathVariable String email) throws Exception {
        return new ResponseEntity<>(facultyService.fetchByEmail(email), HttpStatus.OK);
    }


    @PutMapping(value = "/updateFaculty/{email}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateFaculty(@PathVariable String email, @RequestBody Faculty data) throws Exception {
        return new ResponseEntity<>(facultyService.update(data, email), HttpStatus.OK);
    }


    // email verification
    @GetMapping(value = "/verify")
    public String verifyMail(@Param("code") String code, HttpServletResponse httpServletResponse) throws JSONException {
        Faculty res_data = facultyService.checkEmailVerification(code);

        if (res_data != null) {
            httpServletResponse.setHeader("Location", "http://localhost:3001/emailverification/" + res_data.getName());
            httpServletResponse.setStatus(302);
        }

        return "not verified";

    }





    // reset forgot password (requesting for otp)
    @PostMapping(value = "/forgotpassword/generate/otp")
    public ResponseEntity<?> forgotPassword(@RequestBody FetchFacultyTable data) throws Exception {
        return facultyImpl.forgotPassword(data);
    }

    // otp verification
    @PostMapping(value = "/forgotpassword/reset")
    public ResponseEntity<?> resetPassword(@RequestBody OtpVerification data) throws Exception {
        return facultyImpl.otpVerification(data);
    }


    // changing new password..
    @PostMapping(value = "/newpassword")
    public ResponseEntity<?> changeNewPassword(@RequestBody SetNewPassword data) throws Exception {
        return facultyImpl.changeNewPassword(data);
    }


}
