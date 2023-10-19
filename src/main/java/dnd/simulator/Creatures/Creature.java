package dnd.simulator.creatures;

import java.util.ArrayList;
import java.util.HashMap;

import dnd.simulator.creatures.feats.Feat;
import dnd.simulator.creatures.skills.Skill;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Creature")
@Getter
@Setter
public class Creature {
    @Id
    @Column(name = "creature")
    private String species;
    
    private String type;
    private String subtype;
    private String size;
    private int speed;
    private String characterClass;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private ArrayList<Feat> feats;
    private int baseAttack;
    private ArrayList<Skill> skills;
    private HashMap<String, Integer> classLevels;
}
