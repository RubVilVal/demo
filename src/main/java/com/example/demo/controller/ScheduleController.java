package com.example.demo.controller;

import com.example.demo.entities.Schedule;
import com.example.demo.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping
    public ResponseEntity getAllSchedules() {
        return ResponseEntity.ok(this.scheduleRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity getOneSchedule(@PathVariable Long id){
        return ResponseEntity.ok(this.scheduleRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity createSchedule(@RequestBody Schedule schedule){
        return ResponseEntity.status(201).body(this.scheduleRepository.save(schedule));
    }

    @PutMapping("{id}")
    public ResponseEntity updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule){
        Schedule scheduleToUpdate = this.scheduleRepository.findById(id).get();
        scheduleToUpdate.setTime(schedule.getTime());
        scheduleToUpdate.setStation_id(schedule.getStation_id());
        scheduleToUpdate.setTrain_number(schedule.getTrain_number());
        return ResponseEntity.ok(this.scheduleRepository.save(scheduleToUpdate));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteSchedule(@PathVariable Long id){
        Schedule schedule = this.scheduleRepository.findById(id).get();
        this.scheduleRepository.deleteById(id);
        return ResponseEntity.ok(schedule);
    }
}
