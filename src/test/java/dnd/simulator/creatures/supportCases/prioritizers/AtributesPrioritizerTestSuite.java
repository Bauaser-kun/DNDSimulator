package dnd.simulator.creatures.supportCases.prioritizers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AtributesPrioritizerTestSuite {
    private AtributesPrioritizer prioritizer = new AtributesPrioritizer();
    
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
        defenderAtributes.forEach(atribute ->{ 
            System.out.println(atribute);
        });
        
        //Then
        assertEquals("Constitution", defenderAtributes.get(0));
    }
}
