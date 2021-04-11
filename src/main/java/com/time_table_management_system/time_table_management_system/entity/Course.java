package com.time_table_management_system.time_table_management_system.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;
    private String name;
    private String dept;


    protected Course() {
    }

    public Course(String code, String name, String dept) {
        this.code = code;
        this.name = name;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

//    public ClassSlot getClassSlot() {
//        return classSlot;
//    }
//
//    public void setClassSlot(ClassSlot classSlot) {
//        this.classSlot = classSlot;
//    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
