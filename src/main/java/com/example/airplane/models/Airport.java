package com.example.airplane.models;

import javax.persistence.*;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Airport;

    @ManyToOne
    private Airplane airplane;

    public Airport() {
    }

    public Airport(long id, String airport, Airplane airplane) {
        this.id = id;
        Airport = airport;
        this.airplane = airplane;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAirport() {
        return Airport;
    }

    public void setAirport(String airport) {
        Airport = airport;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
}
