/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sandraixchel.SonrisaDental.repository;

import com.sandraixchel.SonrisaDental.model.Staff;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sandy
 */
public interface StaffRepository extends CrudRepository <Staff , Integer > {
    
    Staff findFirstByEmailAndRole(String email, String role); //new function to find a staff object by email address
    
    List <Staff> findByRole(String role); //new function to find a (satff) dentist object by role
    
}
