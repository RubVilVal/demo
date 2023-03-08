package com.example.demo.controller;

import com.example.demo.entities.Train;
import com.example.demo.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/train")
public class TrainController {
    @Autowired
    private final TrainRepository trainRepository;

    public TrainController(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @GetMapping
    public ResponseEntity getAllTrains() {
        return ResponseEntity.ok(this.trainRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity getOneTrain(@PathVariable Long id){
        return ResponseEntity.ok(this.trainRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity createTrain(@RequestBody Train train){
        return ResponseEntity.status(201).body(this.trainRepository.save(train));
    }

    @PutMapping("{id}")
    public ResponseEntity updateTrain(@PathVariable Long id, @RequestBody Train train){
        Train trainToUpdate = this.trainRepository.findById(id).get();
        trainToUpdate.setSeats(train.getSeats());
        return ResponseEntity.ok(this.trainRepository.save(trainToUpdate));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTrain(@PathVariable Long id){
        Train train = this.trainRepository.findById(id).get();
        this.trainRepository.deleteById(id);
        return ResponseEntity.ok(train);
    }
}
