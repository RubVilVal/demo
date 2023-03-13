package com.example.demo.controller;

import com.example.demo.entities.Passenger;
import com.example.demo.repository.PassengerRepository;
import com.example.demo.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    private final PassengerRepository passengerRepository;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PassengerController(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @GetMapping
    public ResponseEntity getAllPassengers() {
        return ResponseEntity.ok(this.passengerRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity getOnePassenger(@PathVariable Long id){
        return ResponseEntity.ok(this.passengerRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity createPassenger(@RequestBody Passenger passenger){
        return ResponseEntity.status(201).body(this.passengerRepository.save(passenger));
    }

    @PutMapping("{id}")
    public ResponseEntity updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger){
        Passenger passengerToUpdate = this.passengerRepository.findById(id).get();
        passengerToUpdate.setName(passenger.getName());
        passengerToUpdate.setSurname(passenger.getSurname());
        passengerToUpdate.setDate_of_birth(passenger.getDate_of_birth());
        passengerToUpdate.setPassword(passenger.getPassword());
        passengerToUpdate.setRole(passenger.getRole());
        return ResponseEntity.ok(this.passengerRepository.save(passengerToUpdate));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePassenger(@PathVariable Long id){
        Passenger passenger = this.passengerRepository.findById(id).get();
        this.passengerRepository.deleteById(id);
        return ResponseEntity.ok(passenger);
    }

    // HTML CONTROLLERS

    @GetMapping("/addPassengerForm")
    public ModelAndView addPassengerForm() {
        ModelAndView mav = new ModelAndView("add-passenger-form");
        Passenger newPassenger = new Passenger();
        mav.addObject("passenger", newPassenger);
        return mav;
    }

    @PostMapping("/savePassenger")
    public String savePassenger(@ModelAttribute Passenger passenger){
        passenger.setPassword(passwordEncoder.encode(passenger.getPassword()));
        passenger.setRole("ROLE_USER");
        passengerRepository.save(passenger);
        return "redirect:/home";
    }

}
