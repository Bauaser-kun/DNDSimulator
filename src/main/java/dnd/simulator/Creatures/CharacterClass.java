package dnd.simulator.creatures;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classes")
public class CharacterClass {
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

    @Column(name = "type")
    public String classType;

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

    public void setClassName(String className) {
        this.className = className;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public void setImportantAtributes(ArrayList<String> importantAtributes) {
        this.importantAtributes = importantAtributes;
    }

    public void setSpellcaster(boolean isSpellcaster) {
        this.isSpellcaster = isSpellcaster;
    }

    public void setSpellAtribute(String spellAtribute) {
        this.spellAtribute = spellAtribute;
    }

    public void setHasLimitedSpellsCount(boolean hasLimitedSpellsCount) {
        this.hasLimitedSpellsCount = hasLimitedSpellsCount;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}
