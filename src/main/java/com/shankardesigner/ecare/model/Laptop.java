package com.shankardesigner.ecare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lid;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id",nullable = false)
    @JsonIgnore
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Laptop() {
    }

    public Laptop(String name,Student student) {
        this.name = name;
        this.student =  student;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
