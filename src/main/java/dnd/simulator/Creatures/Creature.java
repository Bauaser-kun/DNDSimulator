package dnd.simulator.Creatures;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Creature")
public class Creature {
    String type;
    String subtype;
    String size;
    String speed;
    String characterClass;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
}
