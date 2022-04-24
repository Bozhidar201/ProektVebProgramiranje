package com.example.wp_project_original.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;

    private String time;

    private String nameOfBand;

    private String description;

    public Event(String time, String nameOfBand, String description) {
        this.time = time;
        this.nameOfBand = nameOfBand;
        this.description = description;
    }
    public Event(){

    }

    public Long getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getNameOfBand() {
        return nameOfBand;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setNameOfBand(String nameOfBand) {
        this.nameOfBand = nameOfBand;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
