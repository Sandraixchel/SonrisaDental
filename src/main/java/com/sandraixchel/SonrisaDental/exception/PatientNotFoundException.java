/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.exception;

/**
 *
 * @author Sandy
 */
public class PatientNotFoundException extends RuntimeException {
    
     public PatientNotFoundException(Integer id){
        
        super ("Could not find the patient with id " + id);
     }
    
}
