package com.example.airplane.repositories;

import com.example.airplane.models.Airplane;
import com.example.airplane.models.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {
}
