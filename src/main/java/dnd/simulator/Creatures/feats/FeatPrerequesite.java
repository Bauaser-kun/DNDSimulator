package dnd.simulator.creatures.feats;

import java.util.ArrayList;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FeatPrerequesite {
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private ArrayList<String> feats;
    private Map<String, Integer> skills;
    private String special;
}