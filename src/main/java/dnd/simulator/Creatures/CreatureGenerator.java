package dnd.simulator.creatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import dnd.simulator.creatures.supportCases.prioritizers.AtributesPrioritizer;
import dnd.simulator.creatures.supportCases.rolls.BasicRolls;
import dnd.simulator.creatures.supportCases.rolls.EliteRolls;
import dnd.simulator.creatures.supportCases.rolls.GoodRolls;
import io.micrometer.common.lang.Nullable;

@Component
public class CreatureGenerator {
    AtributesPrioritizer atributesPrioritizer = new AtributesPrioritizer();

    public Creature generateCreature(Map<String, String> stringProperties, String rollsUsed) {
        String role = "Attacker";
        Creature creature = new Creature();
        creature.type = stringProperties.get("type");
        creature.characterClass = stringProperties.get("className");

        creature = this.assignRolls(creature, creature.characterClass, rollsUsed, role);

        return creature;
    }

    public Creature assignRolls(Creature creature, @Nullable String className, String rollsUsed, String role) {
        List<Integer> atributeValues = new ArrayList<>();
        List<String> prioritizedAtributes = new ArrayList<>();
        
        Map<String, Integer> assignedRolls = new HashMap<>();
        assignedRolls.put("strength", null);
        assignedRolls.put("constitution", null);
        assignedRolls.put("dexterity", null);
        assignedRolls.put("intelligence", null);
        assignedRolls.put("wisdom", null);
        assignedRolls.put("charisma", null);

        switch (rollsUsed) {
            case "basic": 
                atributeValues.add(BasicRolls.HIGHEEST_ROLL.getRoll());
                atributeValues.add(BasicRolls.VERY_HIGH_ROLL.getRoll());
                atributeValues.add(BasicRolls.HIGH_ROLL.getRoll());
                atributeValues.add(BasicRolls.LOW_ROLL.getRoll());
                atributeValues.add(BasicRolls.VERY_LOW_ROLL.getRoll());
                atributeValues.add(BasicRolls.LOWEST_ROLL.getRoll());
                break;
            case "good":
                atributeValues.add(GoodRolls.HIGHEEST_ROLL.getRoll());
                atributeValues.add(GoodRolls.VERY_HIGH_ROLL.getRoll());
                atributeValues.add(GoodRolls.HIGH_ROLL.getRoll());
                atributeValues.add(GoodRolls.LOW_ROLL.getRoll());
                atributeValues.add(GoodRolls.VERY_LOW_ROLL.getRoll());
                atributeValues.add(GoodRolls.LOWEST_ROLL.getRoll());
                break;
            case "elite":
                atributeValues.add(EliteRolls.HIGHEEST_ROLL.getRoll());
                atributeValues.add(EliteRolls.VERY_HIGH_ROLL.getRoll());
                atributeValues.add(EliteRolls.HIGH_ROLL.getRoll());
                atributeValues.add(EliteRolls.LOW_ROLL.getRoll());
                atributeValues.add(EliteRolls.VERY_LOW_ROLL.getRoll());
                atributeValues.add(EliteRolls.LOWEST_ROLL.getRoll());                
                break;
            case "maxed":
                for (int i = 0; i < 6; i++) {
                    atributeValues.add(18);
                }
                break;
            case "custom":
                break;
            default:
                 for (int i = 0; i < 3; i++) {
                    atributeValues.add(11);
                }
                 for (int i = 0; i < 3; i++) {
                    atributeValues.add(10);
                }
        }

        if (className != null ) {
            prioritizedAtributes = atributesPrioritizer.prioritizeAtributes(role, className);
        } else {
            prioritizedAtributes = atributesPrioritizer.prioritizeAtributes(role, creature.type);
        }

        for (int i = 0; i < 6; i++) {
            assignedRolls.put(prioritizedAtributes.get(i), atributeValues.get(i));
        }
      
        creature.strength = assignedRolls.get("strength");
        creature.constitution = assignedRolls.get("constitution");
        creature.dexterity = assignedRolls.get("dexterity");
        creature.intelligence = assignedRolls.get("intelligence");
        creature.wisdom = assignedRolls.get("wisdom");
        creature.charisma = assignedRolls.get("charisma");

        return creature;
    }
}