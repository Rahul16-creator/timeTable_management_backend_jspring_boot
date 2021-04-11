package com.time_table_management_system.time_table_management_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.transaction.Transactional;


@Transactional
@Entity
public class FacultySlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String className;

    @OneToOne(targetEntity = Course.class,cascade = CascadeType.ALL)
    private Course course;


    public FacultySlot(){}

    public FacultySlot(String className, Course course) {
        this.className = className;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "FacultySlot{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", course=" + course +
                '}';
    }
}
