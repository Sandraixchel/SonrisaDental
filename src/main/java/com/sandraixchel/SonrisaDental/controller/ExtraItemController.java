/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.controller;

import com.sandraixchel.SonrisaDental.exception.AppointmentNotFoundException;
import com.sandraixchel.SonrisaDental.exception.ExtraItemsNotFoundException;
import com.sandraixchel.SonrisaDental.model.Appointment;
import com.sandraixchel.SonrisaDental.model.ExtraItem;
import com.sandraixchel.SonrisaDental.repository.AppointmentRepository;
import com.sandraixchel.SonrisaDental.repository.ExtraItemRepository;
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
public class ExtraItemController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ExtraItemRepository extraItemRepository;

//Request to get all extra items stored in a particular appointment
    @GetMapping("/appointment/{appointmentID}/extra_items")
    public List<ExtraItem> getAllExtraItemsByAptID(@PathVariable(value = "appointmentID") int appointmentID) {
        return (List<ExtraItem>) extraItemRepository.findByAppointmentId(appointmentID);
    }

    
//    @PostMapping("/appointments/{appointmentID}/extra_item")
//    public ExtraItem createExtraItem(@PathVariable(value = "appointmentID") int appointmentID, @RequestBody ExtraItem extra_item_request) {
//        ExtraItem extra_item = appointmentRepository.findById(appointmentID).map(appointment ->{
//            appointment.getExtra_items().add(extra_item_request);
//            return extraItemRepository.save(extra_item_request);
//            
//        }) .orElseThrow(() -> new AppointmentNotFoundException (appointmentID) );
//        
//        return extra_item;
    
//    } I couldn't fidure out why is wasn't working so I did the POST request normally, getting the appointment Id from the Front End
    
    @PostMapping("/add_extra_items")
    public ExtraItem createExtraItem(@RequestBody ExtraItem extra_item_request) {
        return extraItemRepository.save(extra_item_request);
    }
    
    //Request to edit extra items details
    @PutMapping("/extra_item/{id}")
    ExtraItem updateExtraItem(@RequestBody ExtraItem newExtraItem, @PathVariable Integer id){
    return extraItemRepository.findById(id)
            .map(extraItem -> {
                extraItem.setItem_name(newExtraItem.getItem_name());
                extraItem.setCost(newExtraItem.getCost());
                
                
                return extraItemRepository.save(extraItem);
                
            }).orElseThrow(()->new ExtraItemsNotFoundException(id));
            
    }

    @DeleteMapping("/extra_items/{id}")
    String deleteExtraItem(@PathVariable Integer id) {
        if (!extraItemRepository.existsById(id)) {
            throw new ExtraItemsNotFoundException(id);
        }

        extraItemRepository.deleteById(id);
        return "Extra Item with ID " + id + " has been deleted successfully";

    }
}
