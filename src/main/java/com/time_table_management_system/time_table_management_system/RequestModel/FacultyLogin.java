package com.time_table_management_system.time_table_management_system.RequestModel;

public class FacultyLogin {

    private String email;
    private String password;


    public FacultyLogin() {
    }

    public FacultyLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
