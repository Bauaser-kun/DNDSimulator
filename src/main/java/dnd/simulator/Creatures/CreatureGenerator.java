package dnd.simulator.Creatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import dnd.simulator.Creatures.supportCases.prioritizers.AtributesPrioritizer;
import dnd.simulator.Creatures.supportCases.rolls.BasicRolls;
import dnd.simulator.Creatures.supportCases.rolls.EliteRolls;
import dnd.simulator.Creatures.supportCases.rolls.GoodRolls;
import io.micrometer.common.lang.Nullable;

@Component
public class CreatureGenerator {
    AtributesPrioritizer atributesPrioritizer = new AtributesPrioritizer();

    public Creature generateCreature(Map<String, String> stringProperties, String rollsUsed) {
        Creature creature = new Creature();
        creature.type = stringProperties.get("type");
        creature.characterClass = stringProperties.get("className");

        creature = this.assignRolls(creature, creature.characterClass, rollsUsed);

        return creature;
    }

    public Creature assignRolls(Creature creature, @Nullable String className, String rollsUsed) {
        int highest = 0;
        int verHigh = 0;
        int high = 0;
        int low = 0;
        int veryLow = 0;
        int lowest = 0;
        Map<String, Integer> assignedRolls = new HashMap<>();

        switch (rollsUsed) {
            case "basic": 
                highest = BasicRolls.HIGHEEST_ROLL.getRoll();
                verHigh = BasicRolls.VERY_HIGH_ROLL.getRoll();
                high = BasicRolls.HIGH_ROLL.getRoll();
                low = BasicRolls.LOW_ROLL.getRoll();
                veryLow = BasicRolls.VERY_LOW_ROLL.getRoll();
                lowest = BasicRolls.LOWEST_ROLL.getRoll();
                break;
            case "good":
                highest = GoodRolls.HIGHEEST_ROLL.getRoll();
                verHigh = GoodRolls.VERY_HIGH_ROLL.getRoll();
                high = GoodRolls.HIGH_ROLL.getRoll();
                low = GoodRolls.LOW_ROLL.getRoll();
                veryLow = GoodRolls.VERY_LOW_ROLL.getRoll();
                lowest = GoodRolls.LOWEST_ROLL.getRoll();
                break;
            case "elite":
                highest = EliteRolls.HIGHEEST_ROLL.getRoll();
                verHigh = EliteRolls.VERY_HIGH_ROLL.getRoll();
                high = EliteRolls.HIGH_ROLL.getRoll();
                low = EliteRolls.LOW_ROLL.getRoll();
                veryLow = EliteRolls.VERY_LOW_ROLL.getRoll();
                lowest = EliteRolls.LOWEST_ROLL.getRoll();                
                break;
            case "maxed":
                highest = 18;
                verHigh = 18;
                high = 18;
                low = 18;
                veryLow = 18;
                lowest = 18;
                break;
            case "custom":
                break;
            default:
                highest = verHigh = high = 11; 
                low = veryLow = lowest = 10;
        }

        if (className != null ) {
            List<String> prioritizedAtributes = atributesPrioritizer.prioritizeAtributes(className);
        } else {
            //List<String> prioritizedAtributes = this.prioritizeAtributes(creature.type);
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