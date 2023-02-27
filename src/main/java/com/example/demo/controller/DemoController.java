package com.example.demo.controller;

import com.example.demo.entities.Station;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DemoController {
    @RequestMapping("/hello")
    @ResponseBody

    public String hello()
    {
        return "hello";
    }

    @PostMapping(value = "/post", produces = "application/json")
    @ResponseBody
    public String post(@RequestBody int id)
    {
        if(id==1) {
            return "ok";
        }
        else {
            return "not ok";
        }
    }

    @GetMapping(value = "/get", produces = "application/json")
    @ResponseBody
    public String get(@RequestBody int id)
    {
        if(id==1) {
            return "ok";
        }
        else {
            return "not ok";
        }
    }

//    @GetMapping(value = "/getstation", produces = "application/json")
//    @ResponseBody
//    public Station getStation(@RequestBody int id)
//    {
//        Station station = new Station (1L);
//        station.setStation_name("abc");
//        return station;
//    }


    @GetMapping(value = "/getstation", produces = "application/json")
    @ResponseBody
    public Station getStation(@RequestParam int id)
    {
        Station station = new Station ((long) id, "granada");
        station.setStation_name("abc");
        return station;
    }

    @GetMapping(value = "/getstation/{id}", produces = "application/json")
    @ResponseBody
    public Station getStation2(@PathVariable int id)
    {
        Station station = new Station ((long) id, "granada");
        station.setStation_name("abc");
        return station;
    }

    @PostMapping(value = "/poststation", consumes = "application/json")
    @ResponseBody
    public Station postStation(@RequestBody Station station)
    {
//        Station station = new Station (1L);
//        station.setStation_name("abc");
        return station;
    }

}
