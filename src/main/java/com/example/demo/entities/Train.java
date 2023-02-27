package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="trains")
public class Train {
    @Id
    private int number;

    @Column(name="seats")
    private int seats;

    public Train() {
    }

    public Train(int number, int seats) {
        this.number = number;
        this.seats = seats;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return number == train.number && seats == train.seats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, seats);
    }

    @Override
    public String toString() {
        return "Train{" +
                "number=" + number +
                ", seats=" + seats +
                '}';
    }
}