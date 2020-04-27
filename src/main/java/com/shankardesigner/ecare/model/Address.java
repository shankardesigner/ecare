package com.shankardesigner.ecare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "VARCHAR(255)")
    private UUID addressId;

    @NotBlank(message = "please select the country.")
    private String country;

    @NotBlank(message = "State can't be empty.")
    private String state;

    @NotBlank(message = "Zone can't be empty.")
    private String zone;

    @NotBlank(message = "District can't be empty.")
    private String district;

    @NotBlank(message = "ward no can't be empty.")
    private String wardNo;

    private String village;

    private String tole;

//    @NotBlank(message = "Post box can't be empty.")
//    private String POB;

    @NotBlank(message = "mobile no can't be empty.")
    private String mobileNo;

    private String telephone;

    @OneToOne(optional=false, mappedBy="address", fetch = FetchType.LAZY)
    @JsonIgnore
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor doctor;

    @OneToOne(optional=false, mappedBy="address", fetch = FetchType.LAZY)
    @JsonIgnore
    private Patient patient;

    public Address() {
    }

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWardNo() {
        return wardNo;
    }

    public void setWardNo(String wardNo) {
        this.wardNo = wardNo;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getTole() {
        return tole;
    }

    public void setTole(String tole) {
        this.tole = tole;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
