package com.example.demo.controller;

import com.example.demo.entities.Station;
import com.example.demo.repository.StationRepository;
import com.example.demo.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/station")
public class StationController {

    @Autowired
    private final StationRepository stationRepository;
    @Autowired
    private StationService stationService;

    public StationController(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @GetMapping
    public ResponseEntity getAllStations() {
        return ResponseEntity.ok(this.stationRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity getOneStation(@PathVariable Long id){
        return ResponseEntity.ok(this.stationRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity createStation(@RequestBody Station station){
        return ResponseEntity.status(201).body(this.stationRepository.save(station));
    }

    @PutMapping("{id}")
    public ResponseEntity updateStation(@PathVariable Long id, @RequestBody Station station){
        Station stationToUpdate = this.stationRepository.findById(id).get();
        stationToUpdate.setStation_name(station.getStation_name());
        return ResponseEntity.ok(this.stationRepository.save(stationToUpdate));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStation(@PathVariable Long id){
        Station station = this.stationRepository.findById(id).get();
        this.stationRepository.deleteById(id);
        return ResponseEntity.ok(station);
    }

    //HTML controllers

    @GetMapping("/showStations")
    public ModelAndView showStations() {
        ModelAndView mav = new ModelAndView("stations");
        List<Station> list = stationRepository.findAll();
        mav.addObject("stations", list);
        return mav;
    }

    @GetMapping("/addStationForm")
    public ModelAndView addStationForm() {
        ModelAndView mav = new ModelAndView("add-station-form");
        Station newStation = new Station();
        mav.addObject("station", newStation);
        return mav;
    }

    @PostMapping("/saveStation")
    public String saveStation(@ModelAttribute Station station) {
        stationRepository.save(station);
        return "redirect:/station/showStations";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long stationId) {
        ModelAndView mav = new ModelAndView("add-station-form");
        Station station = stationRepository.findById(stationId).get();
        mav.addObject("station", station);
        return mav;
    }

    @GetMapping("/deleteStation")
    public String eraseStation(@RequestParam Long stationId) {
        stationRepository.deleteById(stationId);
        return "redirect:/station/showStations";
    }

//    @RequestMapping("/getAll")
//    public String getAll(Model model) {
//        List<Station> stations = stationService.getAll();
//        model.addAttribute("stations", stations);
//        return "stations";
//    }
//
//    @PostMapping("/addNew")
//    public String addNew(Station station) {
//        stationService.addNew(station);
//        return "redirect:/station/getAll";
//    }

}
