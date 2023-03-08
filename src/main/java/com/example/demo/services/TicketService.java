package com.example.demo.services;

import com.example.demo.entities.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAll() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    public void addNew(Ticket ticket) {
        ticketRepository.save(ticket);
    }

}
