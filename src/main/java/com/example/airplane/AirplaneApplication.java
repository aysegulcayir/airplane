package com.example.airplane;

import com.example.airplane.models.Airplane;
import com.example.airplane.repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories( basePackages = "com.example.airplane")
@ComponentScan( basePackages = "com.example.airplane")
public class AirplaneApplication implements CommandLineRunner  {
	AirplaneRepository airplaneRepository;

	public static void main(String[] args) {
		SpringApplication.run(AirplaneApplication.class, args);
	}
@Autowired
public AirplaneApplication(AirplaneRepository airplaneRepository){
		this.airplaneRepository = airplaneRepository;
}
	@Override
	public void run(String... args) throws Exception {
		Airplane airplane = new Airplane(1,"Airbus A300 AA1","London",5);
		airplaneRepository.save(airplane);

	}
}
