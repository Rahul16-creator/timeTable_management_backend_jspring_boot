package com.time_table_management_system.time_table_management_system.RequestModel;

public class FetchClassTimeTable {

    private String code;

    public FetchClassTimeTable() {
    }

    public FetchClassTimeTable(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
