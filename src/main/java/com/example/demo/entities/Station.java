package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="stations")
public class Station {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="station_name")
    private String station_name;

    public Station() {
    }

    public Station(Long id, String station_name) {
        this.id = id;
        this.station_name = station_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(id, station.id) && Objects.equals(station_name, station.station_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, station_name);
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", station_name='" + station_name + '\'' +
                '}';
    }


}

