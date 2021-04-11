package com.time_table_management_system.time_table_management_system.ResponseModel;

public class SuccessMessage {

    private String message;
    private String description;

    public SuccessMessage() {
    }

    public SuccessMessage(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
