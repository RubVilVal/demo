package com.example.demo.controller;

import com.example.demo.entities.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping
    public ResponseEntity getAllTickets() {
        return ResponseEntity.ok(this.ticketRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity getOneTicket(@PathVariable Long id){
        return ResponseEntity.ok(this.ticketRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity createTicket(@RequestBody Ticket ticket){
        return ResponseEntity.status(201).body(this.ticketRepository.save(ticket));
    }

    @PutMapping("{id}")
    public ResponseEntity updateTicket(@PathVariable Long id, @RequestBody Ticket ticket){
        Ticket ticketToUpdate = this.ticketRepository.findById(id).get();
        ticketToUpdate.setPassenger_id(ticket.getPassenger_id());
        ticketToUpdate.setTrain_number(ticket.getTrain_number());
        return ResponseEntity.ok(this.ticketRepository.save(ticketToUpdate));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTicket(@PathVariable Long id){
        Ticket ticket = this.ticketRepository.findById(id).get();
        this.ticketRepository.deleteById(id);
        return ResponseEntity.ok(ticket);
    }
}
