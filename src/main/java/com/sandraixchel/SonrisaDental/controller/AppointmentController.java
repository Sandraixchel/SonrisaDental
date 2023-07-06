/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.controller;

import com.sandraixchel.SonrisaDental.exception.AppointmentNotFoundException;
import com.sandraixchel.SonrisaDental.model.Appointment;
import com.sandraixchel.SonrisaDental.repository.AppointmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sandy
 */

@RestController //It eliminates the need for annotating each method with @ResponseBody.
public class AppointmentController {
    
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    //Request to add a new appointment
    @PostMapping("/appointment") 
    Appointment newAppointment(@RequestBody Appointment newAppointment){
        return appointmentRepository.save(newAppointment);
    }
    
    //Request to view all appointments 
    @GetMapping("/appointments")
    List<Appointment> getAllAppointments(){
        return (List<Appointment>) appointmentRepository.findAll();
    }
    
    //Request to view appointment by ID
    @GetMapping("/appointment/{id}")
    Appointment getAppointmentById(@PathVariable Integer id){
    return appointmentRepository.findById(id)
            .orElseThrow(()->new AppointmentNotFoundException(id));
    }
    
    //Request to edit the appointment
    @PutMapping("/appointment/{id}")
    Appointment updateAppoinment(@RequestBody Appointment newAppointment, @PathVariable Integer id){
    return appointmentRepository.findById(id)
            .map(appointment -> {
                appointment.setType(newAppointment.getType());
                appointment.setDate(newAppointment.getDate());
                appointment.setStart_time(newAppointment.getStart_time());
                appointment.setEnd_time(newAppointment.getEnd_time());
                return appointmentRepository.save(appointment);
                
            }).orElseThrow(()->new AppointmentNotFoundException(id));
            
    }
    
    //Request to delete an appointment by id
    @DeleteMapping("/appointment/{id}")
     String deleteAppointment(@PathVariable Integer id ){
    if(!appointmentRepository.existsById(id)){
        throw new AppointmentNotFoundException(id);
    }
    
    appointmentRepository.deleteById(id);
    return "Appointment with ID " + id + " has been deleted successfully";
    
    }
   
    
    
    
    
    
    @GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
    
}
