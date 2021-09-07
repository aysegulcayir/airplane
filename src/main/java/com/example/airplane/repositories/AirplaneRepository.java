package com.example.airplane.repositories;

import com.example.airplane.models.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
    Iterable<Airplane> findAllByTypeOfPlane(String name);
}
