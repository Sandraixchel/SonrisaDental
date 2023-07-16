/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.services;

import com.sandraixchel.SonrisaDental.exception.DateNotFoundException;
import com.sandraixchel.SonrisaDental.repository.AppointmentRepository;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sandy
 */
@Service //Class to handle logic for checking apts
public class BookingService {

    private int[] possible_startTimes = {8, 9, 10, 11, 13, 14, 15, 16};

    @Autowired
    private AppointmentRepository appointmentRepository; //To inject the apt repo, it will be used to find existing apt in the data base

    //Lists all available apt slots. Returns a Map where the key is a date and the value is an Array List of available start times on that date
    public Map<String, ArrayList<String>> listAvailableAppointments(String selected_date) throws ParseException {

        //Create a new Map object, called free slots
        Map<String, ArrayList<String>> freeSlots = new HashMap<>();

        //String selected_date = "2023-07-17";  // Selected date by the user, passed by the front end

        //Creates a simpleDataFormat object, converting the String date into Date object
        SimpleDateFormat date_formatter = new SimpleDateFormat("yyyy-MM-dd");

        //Creating a new calendar object at the current date and time
        Calendar cal = Calendar.getInstance();

        cal.setTime(date_formatter.parse(selected_date));

        //This code returns a time slot
        //Creates a date format object that will specify the format for converting date objects to Strings
        DateFormat time_formatter = new SimpleDateFormat("HH:mm");

        ArrayList<String> availableTimesForDay = new ArrayList<String>();
        for (int hour : possible_startTimes) { //loop to go through the possible start times Array and return each value as "hour"
            //setting our calendar time to 8am for example
            cal.set(Calendar.HOUR_OF_DAY, hour);
            //To add the hour e.g. 8:00, 9:00, 10:00 etc
            cal.set(Calendar.MINUTE, 00);
            //Convert the calendar object to the formatted String
            String time = time_formatter.format(cal.getTime());
            availableTimesForDay.add(time);
            
            //To add the half hour e.g. 8:30, 9:30, 10:30 etc
            cal.set(Calendar.MINUTE, 30);
            //Convert the calendar object to the formatted String
            time = time_formatter.format(cal.getTime());
            availableTimesForDay.add(time);
            

        }

        //Adding data to the Map
        freeSlots.put(selected_date, availableTimesForDay);

        //Printing the content in the map
        return freeSlots;

    }

}
