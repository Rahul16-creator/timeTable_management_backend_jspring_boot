package com.time_table_management_system.time_table_management_system.service.serviceImpl;

import com.time_table_management_system.time_table_management_system.entity.Faculty;
import com.time_table_management_system.time_table_management_system.repository.FacultyRepository;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Faculty response = facultyRepository.findByEmail(email);
        if (response == null) {
            throw new UsernameNotFoundException("Email id Not Exist Please enter valid Email id");
        }

        return new User(response.getEmail(), response.getPassword(), grantedAuthorities(response.getRole()));
    }

    private Collection<GrantedAuthority> grantedAuthorities(String role) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (role.equals("ADMIN")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (role.equals("HOD")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_HOD"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_FACULTY"));
        }

        return authorities;
    }


    public String returnJsonString(boolean status, String response) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("message", response);
        return jsonObject.toString();
    }

}
