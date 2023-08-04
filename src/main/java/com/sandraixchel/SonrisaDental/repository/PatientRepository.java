/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sandraixchel.SonrisaDental.repository;


import com.sandraixchel.SonrisaDental.model.Patient;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sandy
 */
public interface PatientRepository extends CrudRepository <Patient, Integer>{
    
    Patient findFirstByEmail(String email); //new function to find patient object by email address
    
}
