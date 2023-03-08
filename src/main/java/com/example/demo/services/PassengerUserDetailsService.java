package com.example.demo.services;

import com.example.demo.config.PassengerUserDetails;
import com.example.demo.entities.Passenger;
import com.example.demo.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PassengerUserDetailsService implements UserDetailsService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Passenger> passenger = passengerRepository.findByName(username);
        return passenger.map(PassengerUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user "+username+" not found"));
    }
}
