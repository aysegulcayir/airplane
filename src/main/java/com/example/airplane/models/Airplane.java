package com.example.airplane.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplane {
    //Type of Airplane, Airplane Identification Plate, Current Airfield, Fuel.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long airplaneIdentification;
    private String typeOfAirPlane;
    private String currentAirport;
    private long tankCondition;

    public Airplane() {
    }

    public Airplane(long airplaneIdentification, String typeOfAirPlane, String currentAirport, long tankCondition) {
        this.airplaneIdentification = airplaneIdentification;
        this.typeOfAirPlane = typeOfAirPlane;
        this.currentAirport = currentAirport;
        this.tankCondition = tankCondition;
    }

    public long getAirplaneIdentification() {
        return airplaneIdentification;
    }

    public void setAirplaneIdentification(long airplaneIdentification) {
        this.airplaneIdentification = airplaneIdentification;
    }

    public String getTypeOfAirPlane() {
        return typeOfAirPlane;
    }

    public void setTypeOfAirPlane(String typeOfAirPlane) {
        this.typeOfAirPlane = typeOfAirPlane;
    }

    public String getCurrentAirport() {
        return currentAirport;
    }

    public void setCurrentAirport(String currentAirport) {
        this.currentAirport = currentAirport;
    }

    public long getTankCondition() {
        return tankCondition;
    }

    public void setTankCondition(long tankCondition) {
        this.tankCondition = tankCondition;
    }
}
