package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="surname")
    private String surname;

    @Column(name="date_of_birth")
    private Date date_of_birth;

    public Passenger() {
    }

    public Passenger(Long id, String first_name, String surname, Date date_of_birth) {
        this.id = id;
        this.first_name = first_name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id) && Objects.equals(first_name, passenger.first_name) && Objects.equals(surname, passenger.surname) && Objects.equals(date_of_birth, passenger.date_of_birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, surname, date_of_birth);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", surname='" + surname + '\'' +
                ", date_of_birth=" + date_of_birth +
                '}';
    }

}
