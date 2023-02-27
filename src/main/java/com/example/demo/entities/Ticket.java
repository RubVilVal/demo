package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="passenger_id")
    private Long passenger_id;

    @Column(name="train_number")
    private int train_number;

    public Ticket() {
    }

    public Ticket(Long id, Long passenger_id, int train_number) {
        this.id = id;
        this.passenger_id = passenger_id;
        this.train_number = train_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(Long passenger_id) {
        this.passenger_id = passenger_id;
    }

    public int getTrain_number() {
        return train_number;
    }

    public void setTrain_number(int train_number) {
        this.train_number = train_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return train_number == ticket.train_number && Objects.equals(id, ticket.id) && Objects.equals(passenger_id, ticket.passenger_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passenger_id, train_number);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", passenger_id=" + passenger_id +
                ", train_number=" + train_number +
                '}';
    }
}
