package com.example.demo.controller;

import com.example.demo.entities.Station;
import com.example.demo.entities.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private final TicketRepository ticketRepository;

    @Autowired
    private TicketService ticketService;

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

    //HTML controllers

    @GetMapping("/showTickets")
    public ModelAndView showTickets() {
        ModelAndView mav = new ModelAndView("tickets");
        List<Ticket> list = ticketRepository.findAll();
        mav.addObject("tickets", list);
        return mav;
    }

    @GetMapping("/addTicketForm")
    public ModelAndView addTicketForm() {
        ModelAndView mav = new ModelAndView("add-ticket-form");
        Ticket newTicket = new Ticket();
        mav.addObject("ticket", newTicket);
        return mav;
    }

    @PostMapping("/saveTicket")
    public String saveTicket(@ModelAttribute Ticket ticket) {
        ticketRepository.save(ticket);
        return "redirect:/ticket/showTickets";
    }

//    @RequestMapping("/getAll")
//    public String getAll(Model model) {
//        List<Ticket> tickets = ticketService.getAll();
//        model.addAttribute("tickets", tickets);
//        return "tickets";
//    }
//
//    @PostMapping("/addNew")
//    public String addNew(Ticket ticket) {
//        ticketService.addNew(ticket);
//        return "redirect:/ticket/getAll";
//    }
}
