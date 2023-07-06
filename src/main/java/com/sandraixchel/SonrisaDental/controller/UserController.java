/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandraixchel.SonrisaDental.controller;

import com.sandraixchel.SonrisaDental.exception.UserNotFoundException;
import com.sandraixchel.SonrisaDental.model.User;
import com.sandraixchel.SonrisaDental.repository.UserRepository;
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
public class UserController {
    
    /**
     *  
     * Spring provides annotation-based auto-wiring by providing @Autowired annotation. It is used to autowire spring bean on setter methods, 
     * instance variable, and constructor. When we use @Autowired annotation, the spring container auto-wires the bean by matching data-type.
     */
     @Autowired
    private UserRepository userRepository;

    @PostMapping("/user") //To make POST requests 
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }
    
    @GetMapping("/users")//To get all users
    List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    
    @GetMapping("/user/{id}") //Too get users by id
    User getUserById(@PathVariable Integer id){
    return userRepository.findById(id)
            .orElseThrow(()->new UserNotFoundException(id));
    }
    //For editing the mapping
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Integer id){
    return userRepository.findById(id)
            .map(user -> {
                user.setUsername(newUser.getUsername());
                user.setName(newUser.getName());
                user.setEmail(newUser.getEmail());
                return userRepository.save(user);
                
            }).orElseThrow(()->new UserNotFoundException(id));
            
    }    
    
    //To delete data from the data base
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Integer id ){
    if(!userRepository.existsById(id)){
        throw new UserNotFoundException(id);
    }
    
    userRepository.deleteById(id);
    return "User with ID " + id + " has been deleted successfully";
    
    }
    
    
    
    
}
