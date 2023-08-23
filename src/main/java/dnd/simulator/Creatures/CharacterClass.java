package dnd.simulator.creatures;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classes")
public class CharacterClass {
    public CharacterClass() {}

    @Id
    @Column(name = "class")
    public String className;

    @Column(name = "role")
    public ArrayList<String> roles;

    @Column(name = "spellcaster?")
    public boolean isSpellcaster;

    @Column(name = "spell atribute")
    public String spellAtribute;

    @Column(name = "limited spell count?")
    public boolean hasLimitedSpellsCount;

    @Column(name = "hit Dice")
    public int hitDice;

    public CharacterClass(String className, ArrayList<String> roles, boolean isSpellcaster, String spellAtribute,
            boolean hasLimitedSpellsCount, int hitDice) {
        this.className = className;
        this.roles = roles;
        this.isSpellcaster = isSpellcaster;
        this.spellAtribute = spellAtribute;
        this.hasLimitedSpellsCount = hasLimitedSpellsCount;
        this.hitDice = hitDice;
    }
}
