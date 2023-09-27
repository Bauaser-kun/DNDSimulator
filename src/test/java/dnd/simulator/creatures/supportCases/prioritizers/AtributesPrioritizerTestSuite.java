package dnd.simulator.creatures.supportCases.prioritizers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//@ExtendWith(SpringExtension.class)
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
    }

    @Test
    void testConstitutionAndStrengthIsRemovedWhenIncorporeralUndeadIsCreated() {
        //Given
        String role = "defender";
        String className = "fighter";
        String type = "undead";
        String subtype = "incorporeal";

        //When
        List<String> ghostAtributes = prioritizer.prioritizeAtributes(role, className, type, subtype);

        //Then
        assertEquals(4, ghostAtributes.size());
        assertFalse(ghostAtributes.contains("Constitution"));
        assertFalse(ghostAtributes.contains("Strength"));
    }
}
