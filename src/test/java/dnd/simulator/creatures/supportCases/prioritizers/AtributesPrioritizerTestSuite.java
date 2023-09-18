package dnd.simulator.creatures.supportCases.prioritizers;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        List<String> defenderAtributes = prioritizer.prioritizeAtributes(role, null);
        
        //Then
        assertEquals("Constitution", defenderAtributes.get(0));
        assertEquals(6, defenderAtributes.size());
    }
}
