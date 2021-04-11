package com.time_table_management_system.time_table_management_system.ResponseModel;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class ErrorMessage {

    private String errorName;
    private String errorDescription;

    @CreationTimestamp
    private LocalDateTime CreatedAt;

    protected ErrorMessage() {
    }

    public ErrorMessage(String errorName, String errorDescription) {
        this.errorName = errorName;
        this.errorDescription = errorDescription;
    }

    public ErrorMessage(String errorName, String errorDescription,LocalDateTime createdAt) {
        this.errorName = errorName;
        this.errorDescription = errorDescription;
        this.CreatedAt=createdAt;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }
}
