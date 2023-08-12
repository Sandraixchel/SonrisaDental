/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sandraixchel.SonrisaDental.repository.PatientRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.ColumnDefault;


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
    
    public enum AppointmentStatus{
    
        BOOKED,IN_TREATMENT,LAB_WORK_SENT,LAB_WORK_ARRIVED,CANCELLED,RESCHEDULED,PAID
        
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
    
    private int cost;
    
    @Enumerated(EnumType.STRING)
    //@ColumnDefault("'BOOKED'")
    @Column(name="status")
    private AppointmentStatus status = AppointmentStatus.BOOKED;//Whenever an appointment is created, the satus will be BOOKED by default 

    //This is to represent the relationship between patient and apt, where a patient can have many apt but an apt can only have one px
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id") // marks a column as a join column for an entity association or an element collection
    private Patient patient;
    
    //This is to represent the relationship between staff and apt, where a staff can have many apt but an apt can only have one staff
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staff_id") // marks a column as a join column for an entity association or an element collection
    private Staff staff;
    
    @JsonIgnoreProperties("appointment")
    @OneToMany( mappedBy="appointment", cascade=CascadeType.ALL, orphanRemoval=true)  
    private List<ExtraItem> extra_items = new ArrayList<>();
    

    public int getId() {
        return id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public List<ExtraItem> getExtra_items() {
        return extra_items;
    }

    public void setExtra_items(List<ExtraItem> extra_items) {
        this.extra_items = extra_items;
    }
    
    
}
