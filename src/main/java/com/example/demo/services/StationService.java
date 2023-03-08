package com.example.demo.services;

import com.example.demo.entities.Passenger;
import com.example.demo.entities.Station;
import com.example.demo.repository.PassengerRepository;
import com.example.demo.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Station> getAll() {
        return (List<Station>) stationRepository.findAll();
    }

    public void addNew(Station station) {
        stationRepository.save(station);
    }

    public String addPassenger(Passenger passenger){
        passenger.setPassword(passwordEncoder.encode(passenger.getPassword()));
        passengerRepository.save(passenger);
        return "user added to system";
    }


}
