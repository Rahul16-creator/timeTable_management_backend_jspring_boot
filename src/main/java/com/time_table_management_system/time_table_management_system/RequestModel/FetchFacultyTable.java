package com.time_table_management_system.time_table_management_system.RequestModel;

public class FetchFacultyTable {

    private String email;

    public FetchFacultyTable() {
    }

    public FetchFacultyTable(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
