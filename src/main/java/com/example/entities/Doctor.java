package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {

    @Id
    private Long doctorId;
    private String firstName;
    private String lastName;
    private String password;

    protected Doctor() {}

    public Doctor(Long doctorId, String firstName, String lastName, String password) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
}
