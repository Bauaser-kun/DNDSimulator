package dnd.simulator.database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import dnd.simulator.DNDSimulatorApplication;
import dnd.simulator.creatures.CharacterClass;

@SpringBootTest
public class ClassRepositoryTestSuite {
    @Autowired
    private ClassRepository classRepository;

    /*@BeforeAll
    static void fillDatabaseBeforeTestsIfNotFilled () {
        DbInitialSetup initialSetup = new DbInitialSetup();
        initialSetup.addClassesToDatabase("defaultClasses.csv");
    }*/

    @Test
    void testSaveClass() {
        //Given
        ArrayList<String> roles = new ArrayList<>(
            List.of("attacker", "defender", "elusive defender", "long range", "reckless attacker", "dexterious attacker"));

        CharacterClass fighter = new CharacterClass("testFighter", roles, new ArrayList<>(), false, "Nothing", false, 10, "basic");

        //When
        classRepository.save(fighter);

        //Then
        assertEquals("testFighter", fighter.className);

        //Cleanup
        classRepository.deleteById("testFighter");
    }
}
