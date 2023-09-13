package dnd.simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import dnd.simulator.database.DbInitialSetup;

@SpringBootApplication
public class DNDSimulatorApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DNDSimulatorApplication.class, args);
		DbInitialSetup initialSetup = applicationContext.getBean(DbInitialSetup.class);
		initialSetup.addClassesToDatabase();
	}
}