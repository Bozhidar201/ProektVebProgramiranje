package com.example.wp_project_original.model;

import javax.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;

    private Integer brLugje;

    @ManyToOne
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Event event;



    public Reservation(User user, Event event, Integer brLugje) {
        this.user = user;
        this.event = event;
        this.brLugje = brLugje;
    }

    public Reservation(){

    }

    public void setBrLugje(Integer brLugje) {
        this.brLugje = brLugje;
    }

    public Integer getBrLugje() {
        return brLugje;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
