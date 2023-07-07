/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.exception;

/**
 *
 * @author Sandy
 */
public class StaffNotFoundException extends RuntimeException {
    
    public StaffNotFoundException(Integer id){
        
        super ("Could not find the staff with id " + id);
    
    }
    
}
