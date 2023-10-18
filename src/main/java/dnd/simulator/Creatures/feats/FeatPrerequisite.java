package dnd.simulator.creatures.feats;

import java.util.ArrayList;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import dnd.simulator.creatures.skills.*;

@Getter
@Setter
@AllArgsConstructor
public class FeatPrerequisite {
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private ArrayList<String> feats;
    private String special;
    private int baseAttack;
    private ArrayList<Skill> skills;
}