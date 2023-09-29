package dnd.simulator.creatures.supportCases.rolls;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dnd.simulator.creatures.Creature;

@SpringBootTest
public class RollsAssignerTestSuite {
    @Autowired
    private RollAssigner rollAssigner;

    @Test
    void shouldAssignOnlyFourAtributesForIncorporalUndead(){
        //Given
        Creature ghost = new Creature("ghost", "undead", "incorporal", "medium", 30, "noClass", 0, 0, 0, 0, 0, 0);
        
        //When
        ghost = rollAssigner.assignRolls(ghost, ghost.getCharacterClass(), "maxed", "defender");

        //Then
        System.out.println("strength: " + ghost.getStrength() + "\n Dexterity: " + ghost.getDexterity() + "\n Constitution: " + ghost.getConstitution()
            + "\n Intelligence: " + ghost.getIntelligence() + "\n Wisdom: " + ghost.getWisdom() + "\n Charisma: " + ghost.getCharisma());
        assertNull(ghost.getStrength());
        assertNull(ghost.getConstitution());
    }
}
