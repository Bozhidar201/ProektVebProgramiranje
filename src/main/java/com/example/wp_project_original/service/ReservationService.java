package com.example.wp_project_original.service;

import com.example.wp_project_original.model.Event;
import com.example.wp_project_original.model.Reservation;
import com.example.wp_project_original.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReservationService {
    List<Reservation> findAll();
    Reservation findById(Long id);
    Reservation create(User user, Event event, Long idEvent, Integer brLugje);
    void delete(Long id);
}
