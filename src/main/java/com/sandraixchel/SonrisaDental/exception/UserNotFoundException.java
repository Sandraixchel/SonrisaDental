/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.exception;

/**
 *
 * @author Sandy
 */
public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(Integer id){ //This funtion will activate if the id can not be found
    
        super ("Could not find the user with id " + id);
    }
    
}
