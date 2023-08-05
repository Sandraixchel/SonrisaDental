/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author Sandy
 */

@Entity
public class ExtraItem {
    
    @Id //We need to add this annotation if we want to auto generate the id value 
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id; 
    
    private String item_name;
    
    private double cost;
    
    //This is to represent the relationship between appointment and extra item, where an appointment can have many extra items but an extra item can only have one appointment
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_id") // marks a column as a join column for an entity association or an element collection
    @JsonIgnoreProperties("extra_items")
    private Appointment appointment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
     
    
    
    
}
