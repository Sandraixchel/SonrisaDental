/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sandraixchel.SonrisaDental.repository;

import com.sandraixchel.SonrisaDental.model.Appointment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sandy
 */


public interface AppointmentRepository extends CrudRepository <Appointment, Integer>{
    
    List<Appointment> findByDate(String date);
    
}
