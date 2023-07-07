/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Sandy
 */

@Entity
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String first_name;
    
    private String last_name;
    
    private String dob;

    private String phone_number;

    private String email;
    
    private String insurance_provider;
    
    private String insurance_number;
    
    
    //This is to represent the relationship between patient and apt, where a patient can have many apt but an apt can only have one px
    @OneToMany(mappedBy="patient", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Appointment> appointments = new ArrayList<>();

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
    
    public String getDob() {
        return dob;
    }
  
    public Integer getId() {
        return id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String getInsurance_provider() {
        return insurance_provider;
    }

    public String getInsurance_number() {
        return insurance_number;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public void setDob(String dob) {
        this.dob = dob;
    }
    

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInsurance_provider(String insurance_provider) {
        this.insurance_provider = insurance_provider;
    }

    public void setInsurance_number(String insurance_number) {
        this.insurance_number = insurance_number;
    }
    
    
    
}
