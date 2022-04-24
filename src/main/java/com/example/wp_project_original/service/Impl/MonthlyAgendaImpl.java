package com.example.wp_project_original.service.Impl;

import com.example.wp_project_original.model.Event;
import com.example.wp_project_original.model.MonthlyAgenda;
import com.example.wp_project_original.repository.MonthlyAgendaRepository;
import com.example.wp_project_original.service.MonthlyAgendaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthlyAgendaImpl implements MonthlyAgendaService {

    private final MonthlyAgendaRepository monthlyAgendaRepository;

    public MonthlyAgendaImpl(MonthlyAgendaRepository monthlyAgendaRepository) {
        this.monthlyAgendaRepository = monthlyAgendaRepository;
    }

    @Override
    public List<MonthlyAgenda>  findAll() {
        return this.monthlyAgendaRepository.findAll();
    }

    @Override
    public MonthlyAgenda create(String mesec, List<Event> eventList) {
        MonthlyAgenda monthlyAgenda = new MonthlyAgenda(mesec);
        this.monthlyAgendaRepository.save(monthlyAgenda);
        return monthlyAgenda;
    }
}
