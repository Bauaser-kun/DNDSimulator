package dnd.simulator.Creatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        }

        List<String> prioritizedAtributes = this.prioritizeAtributes(className);
      
        creature.strength = assignedRolls.get("strength");
        creature.constitution = assignedRolls.get("constitution");
        creature.dexterity = assignedRolls.get("dexterity");
        creature.intelligence = assignedRolls.get("intelligence");
        creature.wisdom = assignedRolls.get("wisdom");
        creature.charisma = assignedRolls.get("charisma");

        return creature;
    }

    public List<String> prioritizeAtributes(String className) {
        List<String> prioritized = new ArrayList<String>(); 
        CharacterClass currentClass = new CharacterClass();
        Map<String, Integer> priorities = generateBasicClassPriorities(currentClass.role);

        return prioritized;
    }

    public Map<String, Integer> generateBasicClassPriorities(String role) {
        Map<String, Integer> priorities = new HashMap<>();
            priorities.put("Strength", 0);
            priorities.put("Constitution", 0);
            priorities.put("Dexterity", 0);
            priorities.put("Intelligence", 0);
            priorities.put("Wisdom", 0);
            priorities.put("Charisma", 0);

        switch (role) {
            case "attacker":
                priorities.put("Strength", priorities.get("Strength") + 1);
                priorities.put("Constitution", priorities.get("Constitution") + 1);
                priorities.put("Dexterity", priorities.get("Dexterity" + 1));
                break;
            case "elusive defender":
                priorities.put("Constitution", priorities.get("Constitution") + 2);
                priorities.put("Dexterity", priorities.get("Dexterity" + 1));
                break;
            case "defender":
                priorities.put("Constitution", priorities.get("Constitution") + 2);
                priorities.put("Strength", priorities.get("Strength" + 1));
                break;
            case "long range":
                priorities.put("Dexterity", priorities.get("Dexterity") + 2);
                priorities.put("Constitution", priorities.get("Constitution" + 1));
                break;
            case "wise healer":
                priorities.put("Wisdom", priorities.get("Wisdom") + 2);
                priorities.put("Constitution", priorities.get("Constitution" + 1));
                break;
            case "reckless healer":
                priorities.put("Wisdom", priorities.get("Wisdom") + 2);
                priorities.put("Strength", priorities.get("Strength" + 1));
                break;
            case "undead healer":
                priorities.put("Wisdom", priorities.get("Wisdom") + 2);
                priorities.put("Charisma", priorities.get("Charisma" + 1)); 
                break;
            case "support mage":
                priorities.put("Intelligence", priorities.get("Intelligence") + 1);
                priorities.put("Constitution", priorities.get("Constitution" + 1)); 
                priorities.put("Dexterity", priorities.get("Dexterity") + 1);
                break;
            case "support sorcerer":
                priorities.put("Charisma", priorities.get("Charisma") + 1);
                priorities.put("Constitution", priorities.get("Constitution" + 1)); 
                priorities.put("Dexterity", priorities.get("Dexterity") + 1);
                break;
            case "artillery mage":
                priorities.put("Intelligence", priorities.get("Intelligence") + 2);
                priorities.put("Constitution", priorities.get("Constitution" + 1)); 
                break;
            case "artillery sorcerer":
                priorities.put("Charisma", priorities.get("Charisma") + 2);
                priorities.put("Constitution", priorities.get("Constitution" + 1)); 
                break;
            case "debuff mage":
                priorities.put("Intelligence", priorities.get("Intelligence") + 1);
                priorities.put("Constitution", priorities.get("Constitution" + 1)); 
                priorities.put("Dexterity", priorities.get("Dexterity") + 1);
                break;
            case "debuff sorcerer":
                priorities.put("Charisma", priorities.get("Charisma") + 1);
                priorities.put("Constitution", priorities.get("Constitution" + 1)); 
                priorities.put("Dexterity", priorities.get("Dexterity") + 1);
                break;
            case "stealth":
                priorities.put("Dexterity", priorities.get("Dexterity") + 2);
                priorities.put("Constitution", priorities.get("Constitution" + 1));
                break;
            case "reckless attacker":
                priorities.put("Constitution", priorities.get("Constitution") + 1);
                priorities.put("Strength", priorities.get("Strength" + 2));
                break;
            case "dexterious attacker":
                priorities.put("Dexterity", priorities.get("Dexterity") + 1);
                priorities.put("Strength", priorities.get("Strength" + 2));
                break;
            default:
                break;
        }

        return priorities;
    }
}