/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.repository;

import com.sandraixchel.SonrisaDental.model.ExtraItem;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sandy
 */
public interface ExtraItemRepository extends CrudRepository <ExtraItem, Integer> {
    
    List<ExtraItem>findByAppointmentId(int appointment_id);    
}
