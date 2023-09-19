package dnd.simulator.creatures;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Creature")
public class Creature {
    @Id
    String species;
    
    private String type;
    private String subtype;
    private String size;
    private String speed;
    private String characterClass;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSubtype() {
        return subtype;
    }
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getSpeed() {
        return speed;
    }
    public void setSpeed(String speed) {
        this.speed = speed;
    }
    public String getCharacterClass() {
        return characterClass;
    }
    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getDexterity() {
        return dexterity;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    public int getConstitution() {
        return constitution;
    }
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getWisdom() {
        return wisdom;
    }
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }
    public int getCharisma() {
        return charisma;
    }
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
