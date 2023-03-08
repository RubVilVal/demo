package com.example.demo.controller;

import com.example.demo.entities.Passenger;
import com.example.demo.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private StationService stationService;

    @RequestMapping("/home")
    public String test() {
        return "index";
    }

    @PostMapping("/new")
    public String addNewPassenger(@RequestBody Passenger passenger){
        return stationService.addPassenger(passenger);
    }

}
