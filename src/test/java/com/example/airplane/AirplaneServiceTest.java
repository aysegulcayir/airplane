package com.example.airplane;

import com.example.airplane.exceptions.BadException;
import com.example.airplane.models.Airplane;
import com.example.airplane.repositories.AirplaneRepository;
import com.example.airplane.services.AirplaneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AirplaneServiceTest {

    @InjectMocks
    private AirplaneService airplaneService;

    @Mock
    private AirplaneRepository airplaneRepository;


    @Test
    public void createNullLicenseFailTest() {
        Airplane airplaneCreated = new Airplane(
                1, "BOING", "London", 5);
        try {
            Airplane createdAirplane = this.airplaneService.saveAirplane(airplaneCreated);
        } catch (BadException exception) {

            Assertions.assertEquals(BadException.class, exception.getClass());
        }
    }

    @Test
    public void createSuccessTest() {
        Airplane airplaneCreated = new Airplane(
                1, "BOING", "London", 5);
        Mockito.when(this.airplaneRepository.save(airplaneCreated)).thenReturn(airplaneCreated);

        Airplane createdAirplane = this.airplaneService.saveAirplane(airplaneCreated);

        Assertions.assertEquals(
                airplaneCreated.getAirplaneIdentification(),createdAirplane.getAirplaneIdentification());


    }

    @Test
    public void getAllTest() {
        List<Airplane> dummyData = new ArrayList<>();
        dummyData.add(new Airplane(1, "BOING", "London", 5));
        dummyData.add(new Airplane(2, "BOING", "USA", 5));
        Mockito.when(this.airplaneRepository.findAll()).thenReturn(dummyData);
        List<Airplane> returnedAirplanes = (List<Airplane>)this.airplaneService.getAll();
        Assertions.assertEquals(dummyData.size(),returnedAirplanes.size());
        Assertions.assertEquals("London",returnedAirplanes.get(0).getCurrentAirport());

    }


}
