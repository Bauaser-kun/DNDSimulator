package dnd.simulator.creatures.supportCases.rolls;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void shouldAsssignAllAtributesTo18whenMaxedRollsAreSelected(){
        //Given
        Creature creature = new Creature();

        //When
        creature = rollAssigner.assignRolls(creature, null, "maxed", "defender");

        //Then
        assertEquals(18, creature.getStrength());
        assertEquals(18, creature.getDexterity());
        assertEquals(18, creature.getConstitution());
        assertEquals(18, creature.getIntelligence());
        assertEquals(18, creature.getWisdom());
        assertEquals(18, creature.getCharisma());

    }

    @Test
    void shouldAssignOnlyFourAtributesForIncorporalUndead(){
        //Given
        Creature ghost = new Creature("ghost", "undead", "incorporeal", "medium", 30, "noClass", 0, 0, 0, 0, 0, 0);
        
        //When
        ghost = rollAssigner.assignRolls(ghost, ghost.getCharacterClass(), "maxed", "defender");

        //Then
        assertNull(ghost.getStrength());
        assertNull(ghost.getConstitution());
        assertEquals(18, ghost.getDexterity());
        assertEquals(18, ghost.getIntelligence());
        assertEquals(18, ghost.getWisdom());
        assertEquals(18, ghost.getCharisma());
        }
}
