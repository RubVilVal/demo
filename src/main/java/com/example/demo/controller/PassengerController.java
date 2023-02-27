package com.example.demo.controller;

import com.example.demo.entities.Passenger;
import com.example.demo.repository.PassengerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    private final PassengerRepository passengerRepository;

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
        passengerToUpdate.setFirst_name(passenger.getFirst_name());
        passengerToUpdate.setSurname(passenger.getSurname());
        passengerToUpdate.setDate_of_birth(passenger.getDate_of_birth());
        return ResponseEntity.ok(this.passengerRepository.save(passengerToUpdate));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePassenger(@PathVariable Long id){
        Passenger passenger = this.passengerRepository.findById(id).get();
        this.passengerRepository.deleteById(id);
        return ResponseEntity.ok(passenger);
    }
}
