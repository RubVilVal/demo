package com.example.demo.controller;

import com.example.demo.entities.Passenger;
import com.example.demo.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String login() {
        return "login_signup";
    }

    @RequestMapping("/home")
    public String test() {
        return "index";
    }

}
