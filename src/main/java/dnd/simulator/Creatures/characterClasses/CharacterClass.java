package dnd.simulator.creatures.characterClasses;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
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

}
