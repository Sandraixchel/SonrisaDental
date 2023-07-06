/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.model;

//import static jakarta.persistence.CascadeType.ALL;
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

    private String name;

    private String phone_number;

    private String email;
    
    private String insurance_provider;
    
    private String insurance_number;
    
    
    
    @OneToMany(mappedBy="patient", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Appointment> appointments = new ArrayList<>();
  

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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
