/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.exception;

/**
 *
 * @author Sandy
 */
public class AppointmentNotFoundException extends RuntimeException{
    
    public AppointmentNotFoundException(Integer id){
        
        super ("Could not find the appointment with id " + id);
    }
}
