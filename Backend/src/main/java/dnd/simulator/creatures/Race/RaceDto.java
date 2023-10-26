package dnd.simulator.creatures.Race;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RaceDto {
    public String name;

    public String type;

    public String subtype;

    public Integer strength;

    public Integer dexterity;

    public Integer constitution;

    public Integer intelligence;

    public Integer wisdom;

    public Integer charisma;

    public ArrayList<String> bonusFeats;

    public ArrayList<String> defaultFeats;

    public ArrayList<String> specialAbilities;
}
