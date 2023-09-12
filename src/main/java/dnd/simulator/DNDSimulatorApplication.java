package dnd.simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dnd.simulator.database.DbInitialSetup;

@SpringBootApplication
public class DNDSimulatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(DNDSimulatorApplication.class, args);

		DbInitialSetup setup = new DbInitialSetup();
		setup.addClassesToDatabase();
	}

}