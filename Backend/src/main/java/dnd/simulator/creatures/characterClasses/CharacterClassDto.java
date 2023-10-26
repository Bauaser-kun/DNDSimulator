package dnd.simulator.creatures.characterClasses;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CharacterClassDto {
    public CharacterClassDto() {}

    public String className;

    public ArrayList<String> roles;

    public ArrayList<String> importantAtributes;

    public boolean isSpellcaster;

    public String spellAtribute;

    public boolean hasLimitedSpellsCount;

    public int hitDice;

    public String classType;
}
