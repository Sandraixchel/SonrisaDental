/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Sandy
 */
//@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class DateNotFoundException extends RuntimeException{
    
    public DateNotFoundException(String date){
        
        super (date + " Is not a valid date");
    
    }
    
}
