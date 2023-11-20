package dnd.simulator.dto;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeatPrerequisiteDto {
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private ArrayList<String> feats;
    private String special;
    private int baseAttack;
    private ArrayList<SkillDto> skills;
    private HashMap<String, Integer> classLevels;
}