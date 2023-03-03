package com.example.demo.services;

import com.example.demo.entities.Station;
import com.example.demo.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;

    public List<Station> getAll() {
        return (List<Station>) stationRepository.findAll();
    }

    public void addNew(Station station) {
        stationRepository.save(station);
    }

}
