package com.example.wp_project_original.web;

import com.example.wp_project_original.service.EventService;
import com.example.wp_project_original.service.MonthlyAgendaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MesechnaAgendaController {

    private final MonthlyAgendaService monthlyAgendaService;
    private final EventService eventService;

    public MesechnaAgendaController(MonthlyAgendaService monthlyAgendaService, EventService eventService) {
        this.monthlyAgendaService = monthlyAgendaService;
        this.eventService = eventService;
    }

    @GetMapping("/mesechnaAgenda")
    public String showMesechnaAgenda(Model model){
        model.addAttribute("events", this.eventService.findAll());
        model.addAttribute("monthlyAgenda", this.monthlyAgendaService.findAll());
        return "mesechnaAgenda.html";
    }

}
