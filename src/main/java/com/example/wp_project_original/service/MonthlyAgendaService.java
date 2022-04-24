package com.example.wp_project_original.service;

import com.example.wp_project_original.model.Event;
import com.example.wp_project_original.model.MonthlyAgenda;

import java.util.List;

public interface MonthlyAgendaService {
    List<MonthlyAgenda> findAll();
    MonthlyAgenda create(String mesec, List<Event> eventList);
}
