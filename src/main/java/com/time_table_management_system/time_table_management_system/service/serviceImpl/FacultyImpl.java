package com.time_table_management_system.time_table_management_system.service.serviceImpl;

import com.time_table_management_system.time_table_management_system.RequestModel.FetchFacultyTable;
import com.time_table_management_system.time_table_management_system.RequestModel.OtpVerification;
import com.time_table_management_system.time_table_management_system.RequestModel.SetNewPassword;
import com.time_table_management_system.time_table_management_system.entity.Faculty;
import com.time_table_management_system.time_table_management_system.repository.FacultyRepository;
import com.time_table_management_system.time_table_management_system.repository.FacultyTimeTableRepository;
import com.time_table_management_system.time_table_management_system.service.FacultyService;
import net.bytebuddy.utility.RandomString;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class FacultyImpl implements FacultyService {


    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private FacultyTimeTableImpl facultyTimeTableImpl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private JavaMailSender mailSender;

    @Override
    public Faculty addFaculty(Faculty data) throws Exception {
        Faculty response = facultyRepository.findByEmail(data.getEmail());
        if (response != null) {
            throw new Exception("Faculty Email already exist");
        }
        data.setPassword(bCryptPasswordEncoder.encode(data.getPassword()));

        boolean table_res = facultyTimeTableImpl.generateFacultyTimeTable(data.getName(), data.getEmail());

        if (!table_res) {
            throw new Exception("Error in creating faculty table");
        }
        String code = generateVerficationCode();
        data.setVerificationCode(code);
        data.setMbverify(false);
        sendVerificationEmail(data);


        return facultyRepository.save(data);
    }

    @Override
    public Faculty deleteFaculty(Faculty data) throws Exception {
        Faculty response = facultyRepository.findByEmail(data.getEmail());
        if (response == null) {
            throw new Exception("Faculty Email Not Exist");
        }

        boolean table_res = facultyTimeTableImpl.deleteFacultyTimeTable(response.getEmail());

        if (!table_res) {
            throw new Exception("Error in deleting faculty table");
        }


//        String code = generateVerficationCode();
//        user.setVerificationCode(code);


        data.setEnabled(false);
        facultyRepository.deleteById(response.getId());
        return response;
    }

    @Override
    public Faculty fetchByEmail(String email) {
        return facultyRepository.findByEmail(email);
    }

    @Override
    public Faculty update(Faculty data, String email) {
        Faculty existData = facultyRepository.findByEmail(email);
        if (existData != null) {
            existData.setImage(data.getImage());
            existData.setName(data.getName());
            existData.setPhoneNumber(data.getPhoneNumber());
            existData.setRole(data.getRole());
            existData.setGender(data.getGender());
            existData.setPassword(existData.getPassword());

        }
        return existData;

    }


    // extra-----------------
    public String generateVerficationCode() {
        String code = RandomString.make(64);
        return code;
    }

    public void sendVerificationEmail(Faculty user) throws Exception {
        String toAddress = user.getEmail();
        String fromAddress = "campaignmanagement.noreply@gmail.com";
        String senderName = "Time Table Management";
        String subject = "Please verify your registration";
        String content = "<div style='padding: 10px 20px;'>"
                + "<img src='https://firebasestorage.googleapis.com/v0/b/react-spring-boot-user-profile.appspot.com/o/images%2Flogo1.ico?alt=media&token=511d4ae0-a523-483d-9943-ba4cd9a6227c'  width='25' height='25' alt='logo'> <span style='font-style:15px'>Campaign Management</span>  <br>"
                + "<h1 style='text-transform: capitalize;'>verify your email</h1>"
                + "<p style='color: #676461;margin: 25px 0;'>Hi [[name]] ! Use the link below to verify your email and start enjoying TimeTable Management </p>"
                + "<a style='text-decoration: none; background-color: #1B98F5; color: #fff; padding: 12px 22px;border-radius: 5px; font-weight: 750; letter-spacing: 0.1rem;' href=\"[[URL]]\" target=\"_self\">Verify email</a>"
                + "<p style='font-size: 15px; margin-top: 25px;'>Questions ? Email us at <span style='color: #1B98F5;font-style: italic;'>campaignmanagement.noreply@gmail.com</span></p>"
                + "</div>" + "Thank you,<br>";

        content = content.replace("[[name]]", user.getName());
        String verifyURL = "http://localhost:3000/" + "verify?code="
                + user.getVerificationCode();

        // String verifyURL = "http://localhost:3001/rest/api/v1/user/verify?code=" +
        // user.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        JSONObject obj = new JSONObject();
        obj.put("fromAddress", fromAddress);
        obj.put("toAddress", toAddress);
        obj.put("senderName", senderName);
        obj.put("subject", subject);
        obj.put("content", content);

        sendMailer(obj);

        // send grid
        // MailService.sendMail(obj);
    }

    public void sendMailer(JSONObject data) throws Exception {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(data.get("fromAddress").toString(), data.get("senderName").toString());
        helper.setTo(data.get("toAddress").toString());
        helper.setSubject(data.get("subject").toString());
        helper.setText(data.get("content").toString(), true);
        mailSender.send(message);

    }

    @Override
    public Faculty checkEmailVerification(String code) throws JSONException {
        Faculty res_data = facultyRepository.findByVerificationCode(code);

        if (res_data != null) {
            res_data.setEnabled(true);
            facultyRepository.save(res_data);
            return res_data;
        }
        return null;
    }

    public String returnJsonString(boolean status, String response) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("message", response);
        return jsonObject.toString();
    }


    public ResponseEntity<?> forgotPassword(FetchFacultyTable data) throws Exception {
        String email = data.getEmail();
        Faculty res_data = facultyRepository.findByEmail(email);
        if (res_data == null) {
            return new ResponseEntity<>(returnJsonString(false, "Enter email Id not found in our database"),
                    HttpStatus.FORBIDDEN);

        }
        if (!res_data.isEnabled()) {
            return new ResponseEntity<>(returnJsonString(false, "Please Verify the email to change password!!"),
                    HttpStatus.FORBIDDEN);
        }

        String otp = generateOtp();
        res_data.setOtp(otp);
        res_data.setTimestamp(System.currentTimeMillis());
        facultyRepository.save(res_data);
        sendForgotPasswordEmail(email, otp);

        return new ResponseEntity<>(returnJsonString(true, "OTP send to the Email please check spam too !!"),
                HttpStatus.OK);
    }

    // otp verification
    public ResponseEntity<?> otpVerification(OtpVerification data) throws Exception {
        Faculty res_data = facultyRepository.findByOtp(data.getOtp());
        if (res_data == null || !res_data.getOtp().equals(data.getOtp()) || !res_data.isEnabled()) {
            return new ResponseEntity<>(returnJsonString(false, "Entered otp was wrong!!"), HttpStatus.FORBIDDEN);

        }
        if (!verifyOtpValidation(res_data.getTimestamp())) {
            return new ResponseEntity<>(returnJsonString(false, "Otp was expired!!"), HttpStatus.FORBIDDEN);
        }

        res_data.setPassword(new BCryptPasswordEncoder().encode(data.getPassword()));

        facultyRepository.save(res_data);

        return new ResponseEntity<>(returnJsonString(true, "Password Changed successfully!!"), HttpStatus.OK);
    }

    public String generateOtp() {
        Random r = new Random(System.currentTimeMillis());
        return Integer.toString(10000 + r.nextInt(20000));
    }


    public void sendForgotPasswordEmail(String email, String otp) throws Exception {
        String toAddress = email;
        String fromAddress = "campaignmanagement.noreply@gmail.com";
        String senderName = "TimeTable Management";
        String subject = "Otp for Forgot password";
        String content = "Dear user,<br>" + "Please take the below otp for change new password <br>" + otp + "<br>"
                + "Thank you";

        JSONObject obj = new JSONObject();
        obj.put("fromAddress", fromAddress);
        obj.put("toAddress", toAddress);
        obj.put("senderName", senderName);
        obj.put("subject", subject);
        obj.put("content", content);

        sendMailer(obj);

        // send grid
        // MailService.sendMail(obj);
    }

    public boolean verifyOtpValidation(Long timestamp) throws Exception {

        Long minutes = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - timestamp);
        if (minutes > 3) {
            return false;
        }
        return true;
    }


    public ResponseEntity<?> changeNewPassword(SetNewPassword data) throws Exception {
        Faculty res_data = facultyRepository.findByEmail(data.getEmail());

        if (!new BCryptPasswordEncoder().matches(data.getOldPassword(), res_data.getPassword())) {
            return new ResponseEntity<>(returnJsonString(false, "old password was wrong"), HttpStatus.FORBIDDEN);

        }
        res_data.setPassword(new BCryptPasswordEncoder().encode(data.getNewPassword()));
        facultyRepository.save(res_data);

        return new ResponseEntity<>(returnJsonString(true, "password changed successfully!!"), HttpStatus.OK);
    }

}
