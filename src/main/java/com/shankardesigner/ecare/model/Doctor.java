package com.shankardesigner.ecare.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "VARCHAR(255)")
    private UUID doctorId;

    @NotBlank(message = "First name can't be empty.")
    private String fname;

    private String mname;

    @NotBlank(message = "Last name can't be empty.")
    private String lname;

    @NotBlank(message = "email can't be empty")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Date of birth can't be empty.")
    @Temporal(TemporalType.DATE) // yesle date matra halxa
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;

    private String fatherName;

    private String motherName;

    private String grandFatherName;

    private String grandMotherName;

    @NotBlank(message = "Please select the gender.")
    private String gender;

    @Valid
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="addressId", unique=true, nullable=false, updatable=false)
    private Address address;

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGrandFatherName() {
        return grandFatherName;
    }

    public void setGrandFatherName(String grandFatherName) {
        this.grandFatherName = grandFatherName;
    }

    public String getGrandMotherName() {
        return grandMotherName;
    }

    public void setGrandMotherName(String grandMotherName) {
        this.grandMotherName = grandMotherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Doctor() {
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", fname='" + fname + '\'' +
                ", mname='" + mname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", grandFatherName='" + grandFatherName + '\'' +
                ", grandMotherName='" + grandMotherName + '\'' +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                '}';
    }
}
