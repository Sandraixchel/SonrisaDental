/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.controller;

import com.sandraixchel.SonrisaDental.exception.StaffNotFoundException;
import com.sandraixchel.SonrisaDental.model.Staff;
import com.sandraixchel.SonrisaDental.repository.StaffRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sandy
 */

@RestController //It eliminates the need for annotating each method with @ResponseBody.
public class StaffController {
    
    @Autowired
    private StaffRepository staffRepository;
    
    //Request to add a new staff
    @PostMapping("/staff") 
    Staff newStaff(@RequestBody Staff newStaff){
        return staffRepository.save(newStaff);
    }
    
    //Request to view all staff 
    @GetMapping("/allstaff")
    List<Staff> getAllStaff(){
        return (List<Staff>) staffRepository.findAll();
    }
    
    //Request to view staff by ID
    @GetMapping("/staff/{id}")
    Staff getStaffById(@PathVariable Integer id){
    return staffRepository.findById(id)
            .orElseThrow(()->new StaffNotFoundException(id));
    }
    
    //Request to edit staff details
    @PutMapping("/staff/{id}")
    Staff updateStaff(@RequestBody Staff newStaff, @PathVariable Integer id){
    return staffRepository.findById(id)
            .map(staff -> {
                staff.setFirst_name(newStaff.getFirst_name());
                staff.setLast_name(newStaff.getLast_name());
                staff.setPhone_number(newStaff.getPhone_number());
                staff.setEmail(newStaff.getEmail());
                staff.setRole(newStaff.getRole());
                staff.setWorking_days(newStaff.getWorking_days());
                return staffRepository.save(staff);
                
            }).orElseThrow(()->new StaffNotFoundException(id));
            
    }
    
    //Request to delete a staff by id
    @DeleteMapping("/staff/{id}")
     String deleteStaff(@PathVariable Integer id ){
    if(!staffRepository.existsById(id)){
        throw new StaffNotFoundException(id);
    }
    
    staffRepository.deleteById(id);
    return "Patient with ID " + id + " has been deleted successfully";
    
    }
    
    
}
