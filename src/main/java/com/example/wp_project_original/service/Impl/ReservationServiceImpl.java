package com.example.wp_project_original.service.Impl;

import com.example.wp_project_original.model.Event;
import com.example.wp_project_original.model.Reservation;
import com.example.wp_project_original.model.User;
import com.example.wp_project_original.model.exceptions.InvalidEventIdException;
import com.example.wp_project_original.model.exceptions.InvalidReservationIdException;
import com.example.wp_project_original.repository.EventRepository;
import com.example.wp_project_original.repository.ReservationRepository;
import com.example.wp_project_original.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final EventRepository eventRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, EventRepository eventRepository) {
        this.reservationRepository = reservationRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Reservation> findAll() {
        return this.reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return this.reservationRepository.findById(id).orElseThrow(InvalidReservationIdException::new);
    }

    @Override
    public Reservation create(User user, Event event, Long idEvent, Integer brLugje) {
        Event event1 = this.eventRepository.findById(idEvent).orElseThrow(InvalidEventIdException::new);
        Reservation reservation = new Reservation(user, event1, brLugje);
        this.reservationRepository.save(reservation);
        return reservation;
    }

    @Override
    public void delete(Long id) {
        this.reservationRepository.deleteById(id);
    }

}
