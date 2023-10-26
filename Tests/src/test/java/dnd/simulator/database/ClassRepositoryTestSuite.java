package dnd.simulator.database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dnd.simulator.creatures.characterClasses.CharacterClass;

@SpringBootTest
public class ClassRepositoryTestSuite {
    @Autowired
    private ClassRepository classRepository;

    @Test
    void testSaveClass() {
        //Given
        ArrayList<String> roles = new ArrayList<>(
            List.of("attacker", "defender", "elusive defender", "long range", "reckless attacker", "dexterious attacker"));

        CharacterClass fighter = new CharacterClass("fighter", roles, new ArrayList<>(), false, "Nothing", false, 10, "basic");

        //When
        classRepository.save(fighter);

        //Then
        assertEquals("fighter", fighter.className);

        //Cleanup
        classRepository.deleteById("fighter");
    }
}
