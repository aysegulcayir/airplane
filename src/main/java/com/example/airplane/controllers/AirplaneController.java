package com.example.airplane.controllers;

import com.example.airplane.exceptions.AlreadyExist;
import com.example.airplane.models.Airplane;
import com.example.airplane.repositories.AirplaneRepository;
import com.example.airplane.services.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@CrossOrigin("**")
@RestController
@RequestMapping("/api")
public class AirplaneController {
    @Autowired
    AirplaneService airplaneService;
    @Autowired
    AirplaneRepository airplaneRepository;

    @GetMapping("/airplanes")
    public Iterable<Airplane> getAirplanes(){
        return this.airplaneService.getAll();
    }
    @GetMapping("/airplane/{id}")
    public ResponseEntity<Airplane> getAirplaneById(@PathVariable long id) {

        Optional<Airplane> airplane = this.airplaneRepository.findById(id);
        return new ResponseEntity<>(airplane.get(), HttpStatus.OK);

    }

    @PostMapping("/airplane")
    public Airplane saveAirplane(@RequestBody Airplane airplane) throws ResponseStatusException {
       if(this.airplaneRepository.existsById(airplane.getAirplaneIdentification())){
           throw new AlreadyExist();
       }this.airplaneService.saveAirplane(airplane);
       return airplane;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Airplane> updateAirplane(@RequestBody Airplane airplane){
        return new ResponseEntity<>(this.airplaneService.updateAirplane(airplane),HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteAirplane(@PathVariable long id){
         this.airplaneRepository.deleteById(id);
    }
}
