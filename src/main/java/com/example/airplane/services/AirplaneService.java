package com.example.airplane.services;

import com.example.airplane.exceptions.BadException;
import com.example.airplane.exceptions.NotFoundException;
import com.example.airplane.models.Airplane;
import com.example.airplane.repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {
    private List<Airplane> airplanes = new ArrayList<>(Arrays.asList(
            new Airplane(1,"Airbus A300 AA1","London",5),
            new Airplane(1,"Boeing 747 AA2","USA",5)));

    @Autowired
    AirplaneRepository airplaneRepository;

    public Iterable<Airplane> getAll(){

        return this.airplaneRepository.findAll();
    }

    public Airplane saveAirplane( Airplane airplane) throws ResponseStatusException {
        if (airplane.getCurrentAirport()=="") {

            throw new BadException();

        }

        return this.airplaneRepository.save(airplane);
    }

    //to change tank condition and current airport
    public Airplane updateAirplane(Airplane airplane){

        Optional<Airplane> tempAirplane = this.airplaneRepository.findById(airplane.getAirplaneIdentification());
        if (tempAirplane == null){
            throw new NotFoundException();
        }else{
           tempAirplane.get().setTankCondition(airplane.getTankCondition());
            tempAirplane.get().setCurrentAirport(airplane.getCurrentAirport());
            this.airplaneRepository.save(tempAirplane.get());}

        return tempAirplane.get();
    }

    public void deleteAirplane(long id){

        Optional<Airplane> airplane = this.airplaneRepository.findById(id);
        this.airplaneRepository.delete(airplane.get());
    }
}
