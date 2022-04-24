package com.example.wp_project_original.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class MonthlyAgenda {
    @Id
    private String mesec;

    @OneToMany
    private List<Event> eventList;

    public MonthlyAgenda(String mesec) {
        this.eventList = new ArrayList<>();
        this.mesec = mesec;
    }

    public MonthlyAgenda(){

    }


    public String getMesec() {
        return mesec;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
