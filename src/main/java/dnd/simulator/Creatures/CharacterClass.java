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

    @Column(name = "important atributes")
    public ArrayList<String> importantAtributes;

    @Column(name = "spellcaster?")
    public boolean isSpellcaster;

    @Column(name = "spell atribute")
    public String spellAtribute;

    @Column(name = "limited spell count?")
    public boolean hasLimitedSpellsCount;

    @Column(name = "hit Dice")
    public int hitDice;

    public CharacterClass(String className, ArrayList<String> roles, boolean isSpellcaster, String spellAtribute,
            boolean hasLimitedSpellsCount, int hitDice, ArrayList<String> importantAtributes) {
        this.className = className;
        this.roles = roles;
        this.isSpellcaster = isSpellcaster;
        this.spellAtribute = spellAtribute;
        this.hasLimitedSpellsCount = hasLimitedSpellsCount;
        this.hitDice = hitDice;
        this.importantAtributes = importantAtributes;
    }

    public String getClassName() {
        return className;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public ArrayList<String> getImportantAtributes() {
        return importantAtributes;
    }

    public boolean isSpellcaster() {
        return isSpellcaster;
    }

    public String getSpellAtribute() {
        return spellAtribute;
    }

    public boolean isHasLimitedSpellsCount() {
        return hasLimitedSpellsCount;
    }

    public int getHitDice() {
        return hitDice;
    }
}
