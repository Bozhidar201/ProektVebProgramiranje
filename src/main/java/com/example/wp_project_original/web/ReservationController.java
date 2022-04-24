package com.example.wp_project_original.web;

import com.example.wp_project_original.model.Event;
import com.example.wp_project_original.model.Reservation;
import com.example.wp_project_original.model.User;
import com.example.wp_project_original.service.AuthService;
import com.example.wp_project_original.service.EventService;
import com.example.wp_project_original.service.ReservationService;
import com.example.wp_project_original.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ReservationController {

    private final ReservationService reservationService;
    private final EventService eventService;
    private final UserService userService;
    private final AuthService authService;

    public ReservationController(ReservationService reservationService, EventService eventService, UserService userService, AuthService authService) {
        this.reservationService = reservationService;
        this.eventService = eventService;
        this.userService = userService;
        this.authService = authService;
    }


    @GetMapping("/listAllReservations")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String listAllReservations(Model model, HttpServletRequest request){
        model.addAttribute("allReservations", this.reservationService.findAll());
        User user = (User) request.getSession().getAttribute("user");

        return "allReservations.html";
    }

    @GetMapping("/events/makeReservation/{id}")
    public String makeReservation(@PathVariable Long id, Model model, HttpServletRequest request){
        Event event = this.eventService.findById(id);
        model.addAttribute("event", event);
        request.getSession().setAttribute("event", event);
        return "makeReservation.html";
    }

    @PostMapping("/makeReservation")
    public String makeReservation(@RequestParam Integer brLugje, HttpServletRequest request){
//        String username = request.getRemoteUser();
//        System.out.println(username);
//        User user12 = this.userService.findByUsername(username);
//        System.out.println(user12.getUsername());
//        Event event = (Event) request.getSession().getAttribute("event");
//        Reservation reservation = new Reservation(user12, event, brLugje);
//        List<Reservation> reservationList = user12.getReservationList();
//        reservationList.add(reservation);
//        user12.setReservationList(reservationList);
        String username = request.getRemoteUser();
        User user = this.userService.findByUsername(username);
        Event event = (Event) request.getSession().getAttribute("event");


        this.reservationService.create(user ,event, event.getId(), brLugje);
        return "redirect:/mesechnaAgenda";
    }


}
