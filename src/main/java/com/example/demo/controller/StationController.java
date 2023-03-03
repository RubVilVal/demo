package com.example.demo.controller;

import com.example.demo.entities.Station;
import com.example.demo.repository.StationRepository;
import com.example.demo.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/station")
public class StationController {
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

    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Station> stations = stationService.getAll();
        model.addAttribute("stations", stations);
        return "stations";
    }

    @PostMapping("/addNew")
    public String addNew(Station station) {
        stationService.addNew(station);
        return "redirect:/station/getAll";
    }
}
