package dnd.simulator.creatures;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Creature")
public class Creature {
    @Id
    String species;
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
