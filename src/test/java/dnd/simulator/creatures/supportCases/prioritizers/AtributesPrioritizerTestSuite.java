package dnd.simulator.creatures.supportCases.prioritizers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AtributesPrioritizerTestSuite {
    @Autowired
    private AtributesPrioritizer prioritizer;
    
    @Test 
    void testGenerateBasicClassPriorities() {
        //Given
        String role = "attacker";
        
        //When
        Map<String,Integer> attackerMap = prioritizer.generateBasicRolesPriorities(role);

        //Then
        assertTrue(attackerMap.size() == 6);
        assertEquals(1, attackerMap.get("Strength"));
        assertEquals(1, attackerMap.get("Dexterity"));
        assertEquals(1, attackerMap.get("Constitution"));
        assertEquals(0, attackerMap.get("Intelligence"));
        assertEquals(0, attackerMap.get("Wisdom"));
        assertEquals(0, attackerMap.get("Charisma"));
    }
    
    @Test 
    void testPrioritizeAtributesWhenNoClassNameIsProvided(){
        //Given
        String role = "defender";

        //When
        List<String> defenderAtributes = prioritizer.prioritizeAtributes(role, null, "testType", "testSubtype");
        
        //Then
        assertEquals("Constitution", defenderAtributes.get(0));
        assertEquals(6, defenderAtributes.size());
    }

    @Test
    void testConstitutionIsRemovedWhenConstructIsCreated() {
        //Given
        String role = "defender";
        String className = "fighter";
        String type = "construct";

        //When
        List<String> conststructAtributes = prioritizer.prioritizeAtributes(role, className, type, "testSubtype");

        //Then
        assertEquals(5, conststructAtributes.size());
        assertFalse(conststructAtributes.contains("Constitution"));
        assertEquals("Strength", conststructAtributes.get(0));
    }

    @Test
    void testConstitutionAndStrengthIsRemovedWhenIncorporeralUndeadIsCreated() {
        //Given
        String role = "elusive defender";
        String className = "fighter";
        String type = "undead";
        String subtype = "incorporeal";

        //When
        List<String> ghostAtributes = prioritizer.prioritizeAtributes(role, className, type, subtype);

        //Then
        assertEquals(4, ghostAtributes.size());
        assertFalse(ghostAtributes.contains("Constitution"));
        assertFalse(ghostAtributes.contains("Strength"));
        assertEquals("Dexterity", ghostAtributes.get(0));
    }

    @Test
    void testAtributePriorityIncreasedForClassImportantAtribute() {
        //Given
        String role = "dexterious attacker";
        String className = "rogue";
        String type = "humanoid";
        String subtype = "elf";

        //When
        List<String> dexteriousAttackerAtributes = prioritizer.prioritizeAtributes(role, "noClass", type, subtype);
        List<String> rogueAtributes = prioritizer.prioritizeAtributes(role, className, type, subtype);

        //Then
        assertNotEquals(dexteriousAttackerAtributes.get(0).toLowerCase(), rogueAtributes.get(0).toLowerCase());
        assertEquals("Strength", dexteriousAttackerAtributes.get(0));
        assertEquals("Dexterity", rogueAtributes.get(0));
    }
}
