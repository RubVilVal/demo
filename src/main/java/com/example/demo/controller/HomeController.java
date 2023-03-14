package com.example.demo.controller;

import org.springframework.stereotype.Controller;
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
