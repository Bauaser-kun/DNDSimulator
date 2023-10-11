package dnd.simulator.creatures;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

import dnd.simulator.creatures.feats.Feat;
import dnd.simulator.creatures.supportCases.Assigner;

@Component
public class CreatureGenerator {
    Assigner assigner = new Assigner();

    public Creature generateCreature(Map<String, String> stringProperties, String rollsUsed, List<Feat> feats) {
        String role = "Attacker";
        Creature creature = new Creature();
        creature.setType(stringProperties.get("type"));
        creature.setCharacterClass(stringProperties.get("className"));

        creature = assigner.assignRolls(creature, creature.getCharacterClass(), rollsUsed, role);
        
        feats.forEach(feat -> {
            creature = assigner.assignFeat(creature, feat);
        });
        

        return creature;
    }

}