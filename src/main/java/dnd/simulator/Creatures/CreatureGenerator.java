package dnd.simulator.Creatures;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import dnd.simulator.Creatures.supportCases.BasicRolls;
import dnd.simulator.Creatures.supportCases.EliteRolls;
import dnd.simulator.Creatures.supportCases.GoodRolls;

@Component
public class CreatureGenerator {
    public Creature generateCreature(Map<String, String> stringProperties, String rollsUsed) {
        Creature creature = new Creature();
        creature.type = stringProperties.get("type");

        creature = this.assignRolls(creature, creature.characterClass, rollsUsed);

        return creature;
    }

    public Creature assignRolls(Creature creature, String className, String rollsUsed) {
        int highest;
        int verHigh;
        int high;
        int low;
        int veryLow;
        int lowest;
        Map assignedRolls = new HashMap<>();

        switch (rollsUsed) {
            case "basic": 
                highest = BasicRolls.HIGHEEST_ROLL.getRoll();
                verHigh = BasicRolls.VERY_HIGH_ROLL.getRoll();
                high = BasicRolls.HIGH_ROLL.getRoll();
                low = BasicRolls.LOW_ROLL.getRoll();
                veryLow = BasicRolls.VERY_LOW_ROLL.getRoll();
                lowest = BasicRolls.VERY_LOW_ROLL.getRoll();
                break;
            case "good":
                highest = GoodRolls.HIGHEEST_ROLL.getRoll();
                verHigh = GoodRolls.VERY_HIGH_ROLL.getRoll();
                high = GoodRolls.HIGH_ROLL.getRoll();
                low = GoodRolls.LOW_ROLL.getRoll();
                veryLow = GoodRolls.VERY_LOW_ROLL.getRoll();
                lowest = GoodRolls.VERY_LOW_ROLL.getRoll();
                break;
            case "elite":
                highest = EliteRolls.HIGHEEST_ROLL.getRoll();
                verHigh = EliteRolls.VERY_HIGH_ROLL.getRoll();
                high = EliteRolls.HIGH_ROLL.getRoll();
                low = EliteRolls.LOW_ROLL.getRoll();
                veryLow = EliteRolls.VERY_LOW_ROLL.getRoll();
                lowest = EliteRolls.VERY_LOW_ROLL.getRoll();                
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
        }

        creature.strength = high;
        creature.constitution = verHigh;
        creature.dexterity = highest;
        creature.intelligence = low;
        creature.wisdom = veryLow;
        creature.charisma = lowest;

        return creature;
    }
}
