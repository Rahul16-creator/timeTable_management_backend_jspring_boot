package com.time_table_management_system.time_table_management_system.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class ClassSlot {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(targetEntity = Faculty.class,cascade = CascadeType.ALL)
    private Faculty faculty;

    @OneToOne(targetEntity = Course.class,cascade = CascadeType.ALL)
    private Course course;


    public ClassSlot() {
    }

    public ClassSlot(Faculty faculty, Course course) {
        this.faculty = faculty;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    @Override
    public String toString() {
        return "ClassSlot{" +
                "id=" + id +
                ", faculty=" + faculty +
                ", course=" + course +
                '}';
    }
}
