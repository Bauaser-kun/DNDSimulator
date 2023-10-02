package dnd.simulator.creatures.supportCases.rolls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import dnd.simulator.creatures.Creature;

//For most tests paladin character class and 'defender' role is selected beacuse if no race, type and subtype is used this 
//build guarantees that constitution will be considered the highest atribute and intelligence will be the lowest priority
@SpringBootTest
public class RollsAssignerTestSuite {
    @Autowired
    private RollAssigner rollAssigner;

    @Test
    void shouldAssignThreeElevensAndThreeTensWhenNoRollsAreSelected(){
        //Given
        Creature creature = new Creature();

        //When
        creature = rollAssigner.assignRolls(creature, null, null, null);

        //Then
        assertThat(creature.getStrength(), anyOf(is(10), is(11)));
        assertThat(creature.getConstitution(), anyOf(is(10), is(11)));
        assertThat(creature.getDexterity(), anyOf(is(10), is(11)));
        assertThat(creature.getIntelligence(), anyOf(is(10), is(11)));
        assertThat(creature.getWisdom(), anyOf(is(10), is(11)));
        assertThat(creature.getCharisma(), anyOf(is(10), is(11)));
    }

    @Test
    void ShouldAssignThirteenAsHighestValueWhenGoodRollsAreSelected(){
        //Given
        Creature creature = new Creature();

        //When
        creature = rollAssigner.assignRolls(creature, "paladin", "good", "defender");

        //Then
        assertEquals(13, creature.getConstitution());
    }

    @Test
    void ShouldAssignFifteenAsHighestValueWhenEliteRollsAreSelected(){
        //Given
        Creature creature = new Creature();

        //When
        creature = rollAssigner.assignRolls(creature, "paladin", "elite", "defender");

        //Then
        assertEquals(15, creature.getConstitution());
    }

    @Test
    void ShouldAssignElevenAsHighestValueWhenBasicRollsAreSelected(){
        //Given
        Creature creature = new Creature();

        //When
        creature = rollAssigner.assignRolls(creature, "paladin", "basic", "defender");

        //Then
        assertEquals(11, creature.getConstitution());
    }

    @Test
    void ShouldAssignEightAsLowestValueWhenGoodRollsAreSelected(){
        //Given
        Creature creature = new Creature();

        //When
        creature = rollAssigner.assignRolls(creature, "paladin", "good", "defender");

        //Then
        assertEquals(8, creature.getIntelligence());
    }

    @Test
    void ShouldAssignEightAsLowestValueWhenEliteRollsAreSelected(){
        //Given
        Creature creature = new Creature();

        //When
        creature = rollAssigner.assignRolls(creature, "paladin", "elite", "defender");

        //Then
        assertEquals(8, creature.getIntelligence());
    }

    @Test
    void ShouldAssignEightAsLowestValueWhenBasicRollsAreSelected(){
        //Given
        Creature creature = new Creature();

        //When
        creature = rollAssigner.assignRolls(creature, "paladin", "basic", "defender");

        //Then
        assertEquals(8, creature.getIntelligence());
    }

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
