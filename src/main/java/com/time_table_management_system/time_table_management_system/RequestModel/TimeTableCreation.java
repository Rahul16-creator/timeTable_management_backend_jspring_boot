package com.time_table_management_system.time_table_management_system.RequestModel;

public class TimeTableCreation {

    private int noOfSub;

    private String className;

    private String subject1Code;
    private String faculty1Email;
    private String subject2Code;
    private String faculty2Email;
    private String subject3Code;
    private String faculty3Email;
    private String subject4Code;
    private String faculty4Email;
    private String subject5Code;
    private String faculty5Email;
    private String subject6Code;
    private String faculty6Email;


    protected TimeTableCreation() {
    }

    public TimeTableCreation(String className, String subject1Code, String faculty1Email, String subject2Code, String faculty2Email, String subject3Code, String faculty3Email, String subject4Code, String faculty4Email, String subject5Code, String faculty5Email, String subject6Code, String faculty6Email) {
        this.className = className;
        this.subject1Code = subject1Code;
        this.faculty1Email = faculty1Email;
        this.subject2Code = subject2Code;
        this.faculty2Email = faculty2Email;
        this.subject3Code = subject3Code;
        this.faculty3Email = faculty3Email;
        this.subject4Code = subject4Code;
        this.faculty4Email = faculty4Email;
        this.subject5Code = subject5Code;
        this.faculty5Email = faculty5Email;
        this.subject6Code = subject6Code;
        this.faculty6Email = faculty6Email;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getNoOfSub() {
        return noOfSub;
    }

    public void setNoOfSub(int noOfSub) {
        this.noOfSub = noOfSub;
    }

    public String getSubject1Code() {
        return subject1Code;
    }

    public void setSubject1Code(String subject1Code) {
        this.subject1Code = subject1Code;
    }

    public String getFaculty1Email() {
        return faculty1Email;
    }

    public void setFaculty1Email(String faculty1Email) {
        this.faculty1Email = faculty1Email;
    }

    public String getSubject2Code() {
        return subject2Code;
    }

    public void setSubject2Code(String subject2Code) {
        this.subject2Code = subject2Code;
    }

    public String getFaculty2Email() {
        return faculty2Email;
    }

    public void setFaculty2Email(String faculty2Email) {
        this.faculty2Email = faculty2Email;
    }

    public String getSubject3Code() {
        return subject3Code;
    }

    public void setSubject3Code(String subject3Code) {
        this.subject3Code = subject3Code;
    }

    public String getFaculty3Email() {
        return faculty3Email;
    }

    public void setFaculty3Email(String faculty3Email) {
        this.faculty3Email = faculty3Email;
    }

    public String getSubject4Code() {
        return subject4Code;
    }

    public void setSubject4Code(String subject4Code) {
        this.subject4Code = subject4Code;
    }

    public String getFaculty4Email() {
        return faculty4Email;
    }

    public void setFaculty4Email(String faculty4Email) {
        this.faculty4Email = faculty4Email;
    }

    public String getSubject5Code() {
        return subject5Code;
    }

    public void setSubject5Code(String subject5Code) {
        this.subject5Code = subject5Code;
    }

    public String getFaculty5Email() {
        return faculty5Email;
    }

    public void setFaculty5Email(String faculty5Email) {
        this.faculty5Email = faculty5Email;
    }

    public String getSubject6Code() {
        return subject6Code;
    }

    public void setSubject6Code(String subject6Code) {
        this.subject6Code = subject6Code;
    }

    public String getFaculty6Email() {
        return faculty6Email;
    }

    public void setFaculty6Email(String faculty7Email) {
        this.faculty6Email = faculty7Email;
    }
}
