/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.controller;

import com.sandraixchel.SonrisaDental.exception.PatientNotFoundException;
import com.sandraixchel.SonrisaDental.model.Patient;
import com.sandraixchel.SonrisaDental.repository.PatientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("http://localhost:3000") //To connect it with REACT
public class PatientController {
    
    @Autowired
    private PatientRepository patientRepository;
    
    //Request to add a new patient
    @PostMapping("/patient") 
    Patient newPatient(@RequestBody Patient newPatient){
        return patientRepository.save(newPatient);
    }
    
    //Request to view all patients 
    @GetMapping("/patients")
    List<Patient> getAllPatients(){
        return (List<Patient>) patientRepository.findAll();
    }
    
    //Request to view patient by ID
    @GetMapping("/patient/{id}")
    Patient getPatientById(@PathVariable Integer id){
    return patientRepository.findById(id)
            .orElseThrow(()->new PatientNotFoundException(id));
    }
    
    //Request to edit the patient details
    @PutMapping("/patient/{id}")
    Patient updatePatient(@RequestBody Patient newPatient, @PathVariable Integer id){
    return patientRepository.findById(id)
            .map(patient -> {
                patient.setFirst_name(newPatient.getFirst_name());
                patient.setLast_name(newPatient.getLast_name());
                patient.setDob(newPatient.getDob());
                patient.setPhone_number(newPatient.getPhone_number());
                patient.setEmail(newPatient.getEmail());
                patient.setInsurance_provider(newPatient.getInsurance_provider());
                patient.setInsurance_number(newPatient.getInsurance_number());
                return patientRepository.save(patient);
                
            }).orElseThrow(()->new PatientNotFoundException(id));
            
    }
    
    //Request to delete a patient by id
    @DeleteMapping("/patient/{id}")
     String deletePatient(@PathVariable Integer id ){
    if(!patientRepository.existsById(id)){
        throw new PatientNotFoundException(id);
    }
    
    patientRepository.deleteById(id);
    return "Patient with ID " + id + " has been deleted successfully";
    
    }
    
    
    
}
