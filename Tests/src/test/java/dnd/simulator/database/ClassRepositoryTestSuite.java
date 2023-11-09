package dnd.simulator.database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dnd.simulator.creatures.CharacterClass;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClassRepository.class})
public class ClassRepositoryTestSuite {
    @Autowired
    private ClassRepository classRepository;

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
