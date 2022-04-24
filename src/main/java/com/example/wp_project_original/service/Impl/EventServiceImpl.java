package com.example.wp_project_original.service.Impl;

import com.example.wp_project_original.model.Event;
import com.example.wp_project_original.model.exceptions.InvalidEventIdException;
import com.example.wp_project_original.repository.EventRepository;
import com.example.wp_project_original.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event findById(Long id) {
        return this.eventRepository.findById(id).orElseThrow(InvalidEventIdException::new);
    }

    @Override
    public List<Event> findAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event create(String time, String nameOfBand, String description) {
        Event event = new Event(time, nameOfBand, description);
        this.eventRepository.save(event);
        return event;
    }

    @Override
    public Event update(Long id, String time, String nameOfBand, String description) {
        Event event = this.findById(id);
        event.setTime(time);
        event.setNameOfBand(nameOfBand);
        event.setDescription(description);
        this.eventRepository.save(event);
        return event;
    }

    @Override
    public void deleteById(Long id) {
        this.eventRepository.deleteById(id);
    }
}
