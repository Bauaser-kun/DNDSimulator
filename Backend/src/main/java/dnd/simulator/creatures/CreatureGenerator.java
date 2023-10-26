package dnd.simulator.creatures;

import java.util.Map;
import org.springframework.stereotype.Component;
import dnd.simulator.creatures.supportCases.rolls.RollAssigner;

@Component
public class CreatureGenerator {
    RollAssigner assigner = new RollAssigner();

    public Creature generateCreature(Map<String, String> stringProperties, String rollsUsed) {
        String role = "Attacker";
        Creature creature = new Creature();
        creature.setType(stringProperties.get("type"));
        creature.setCharacterClass(stringProperties.get("className"));

        creature = assigner.assignRolls(creature, creature.getCharacterClass(), rollsUsed, role);

        return creature;
    }

}