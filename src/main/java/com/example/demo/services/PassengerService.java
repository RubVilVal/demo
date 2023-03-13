package com.example.demo.services;

import com.example.demo.entities.Passenger;
import com.example.demo.entities.Station;
import com.example.demo.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addPassenger(Passenger passenger){
        passenger.setPassword(passwordEncoder.encode(passenger.getPassword()));
        passengerRepository.save(passenger);
        return "user added to system";
    }

    public void addNew(Passenger passenger) {
        passengerRepository.save(passenger);
    }
}
