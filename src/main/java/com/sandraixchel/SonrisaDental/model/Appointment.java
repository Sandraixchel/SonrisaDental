/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


/**
 *
 * @author Sandy
 */

@Entity  // Will auto generate the appointment table in MySQL
public class Appointment {
    
    //Create enu with the different apt types
    public enum AppointmentType{
    
        CLEANING,EXAM,EMERGENCY,FILLING,EXTRACTION,VENEERS, CROWN
    }
    
    @Id //We need to add this annotation if we want to auto generate the id value 
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id; 
    //Spring notation to save the enum as a string into the data base
    @Enumerated(EnumType.STRING)
    @Column(name="type") //Tells the data base in which column the type will need to be added
    private AppointmentType type;
    private String date;
    private String start_time;
    private String end_time;

    //This is to represent the relationship between patient and apt, where a patient can have many apt but an apt can only have one px
    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    public int getId() {
        return id;
    }

    public AppointmentType getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(AppointmentType type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
    
    
}
