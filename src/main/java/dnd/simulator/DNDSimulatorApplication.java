package dnd.simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dnd.simulator.Creatures.CreatureGenerator;

@SpringBootApplication
public class DNDSimulatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(DNDSimulatorApplication.class, args);

		CreatureGenerator generator = new CreatureGenerator();
		generator.assignRolls(null, "fighter", "elite");
	}

}