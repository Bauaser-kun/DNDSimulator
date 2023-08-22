package dnd.simulator.Creatures.supportCases.prioritizers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dnd.simulator.Creatures.CharacterClass;

public class AtributesPrioritizer {
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

    public List<String> prioritizeAtributes(String className) {
        List<String> prioritized = new ArrayList<String>(); 
        CharacterClass currentClass = new CharacterClass();
        Map<String, Integer> priorities = generateBasicClassPriorities(currentClass.role);

        return prioritized;
    }
}
