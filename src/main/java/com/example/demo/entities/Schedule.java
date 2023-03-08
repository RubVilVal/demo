package com.example.demo.entities;

import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.Objects;

@Entity
@Table(name="schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="station_id")
    private Long station_id;

    @Column(name="train_number")
    private int train_number;

    @Column(name="time")
    private Timestamp time;

    public Schedule() {
    }

    public Schedule(Long id, Long station_id, int train_number, Timestamp time) {
        this.id = id;
        this.station_id = station_id;
        this.train_number = train_number;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStation_id() {
        return station_id;
    }

    public void setStation_id(Long station_id) {
        this.station_id = station_id;
    }

    public int getTrain_number() {
        return train_number;
    }

    public void setTrain_number(int train_number) {
        this.train_number = train_number;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return train_number == schedule.train_number && Objects.equals(id, schedule.id) && Objects.equals(station_id, schedule.station_id) && Objects.equals(time, schedule.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, station_id, train_number, time);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", station_id=" + station_id +
                ", train_number=" + train_number +
                ", time=" + time +
                '}';
    }
}