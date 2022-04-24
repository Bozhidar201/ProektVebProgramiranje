package com.example.wp_project_original.service;

import com.example.wp_project_original.model.Event;

import java.util.List;

public interface EventService {
    Event findById(Long id);
    List<Event> findAll();
    Event create(String time, String nameOfBand, String description);
    Event update(Long id, String time, String nameOfBand, String description);
    void deleteById(Long id);
}
