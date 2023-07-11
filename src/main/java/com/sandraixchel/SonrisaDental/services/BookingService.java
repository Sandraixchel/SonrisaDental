/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.services;

import com.sandraixchel.SonrisaDental.repository.AppointmentRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sandy
 */

@Service //Class to handle logic for checking apts
public class BookingService {
    
    @Autowired
    private AppointmentRepository appointmentRepository; //To inject the apt repo, it will be used to find existing apt in the data base
    
    //Lists all available apt slots. Returns a Map where the key is a date and the value is an Array List of available start times on that date
    public Map<LocalDate,ArrayList<String>> listAvailableAppointments(){ 
    
        //Create a new Map object, called free slots
        Map<LocalDate, ArrayList<String>> freeSlots = new HashMap<>();
        
       
        //This code returns a time slot
        
        //Creates a date format object that will specify the format for converting date objects to Strings
        DateFormat formatter = new SimpleDateFormat("hh:mm");
        //Creating a new calendar object at the current time
        Calendar cal = Calendar.getInstance();
        //setting our calendar time to 8am for example
        cal.set(Calendar.HOUR_OF_DAY,8);
        //Convert the calendar object to the formatted String
        String time = formatter.format(cal.getTime());
        
        //Adding data to the Map
        freeSlots.put(LocalDate.now(), new ArrayList<String>(Arrays.asList(time)));
       
        //Printing the content in the map
        return freeSlots;
       
    }
    
}
