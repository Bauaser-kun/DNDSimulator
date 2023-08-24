package dnd.simulator.creatures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import dnd.simulator.creatures.supportCases.prioritizers.AtributesPrioritizer;

@SpringBootTest
public class CreatureGeneratorTestSuite {
    CreatureGenerator generator = new CreatureGenerator();
    AtributesPrioritizer prioritizer = new AtributesPrioritizer();

    @Test
    void testAssignRolls() {
        //Given
        //When
        //THen
    }

    @Test
    void testGenerateCreature() {
        //Given
        //When
        //THen
    }

    @Test 
    void testGenerateBasicClassPriorities() {
        //Given
        String role = "attacker";
        
        //When
        Map<String,Integer> attackerMap = prioritizer.generateBasicRolesPriorities(role);

        //Then
        assertTrue(attackerMap.size() == 6);
        assertEquals(1, attackerMap.get("Strength"));
    }

    @Test
    void testPrioritizeAtributes() {
        //Given
        //When
        //THen
    }
}
