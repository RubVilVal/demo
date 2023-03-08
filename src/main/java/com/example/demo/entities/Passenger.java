package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="date_of_birth")
    private Date date_of_birth;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;

    public Passenger() {
    }

    public Passenger(Long id, String name, String surname, Date date_of_birth, String password, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id) && Objects.equals(name, passenger.name) && Objects.equals(surname, passenger.surname) && Objects.equals(date_of_birth, passenger.date_of_birth) && Objects.equals(password, passenger.password) && Objects.equals(role, passenger.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, date_of_birth, password, role);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", first_name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
