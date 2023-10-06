package dnd.simulator.creatures.Race;

import java.util.ArrayList;

import org.hibernate.mapping.List;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "races")
public class Race {
    @Id
    @Column(name = "name")
    public String name;

    @Column(name = "type")
    public String type;

    @Column(name = "subtype")
    public String subtype;

    @Column(name = "strength")
    public Integer strength;

    @Column(name = "dexterity")
    public Integer dexterity;

    @Column(name = "constitution")
    public Integer constitution;

    @Column(name = "intelligence")
    public Integer intelligence;

    @Column(name = "wisdom")
    public Integer wisdom;

    @Column(name = "charisma")
    public Integer charisma;

    @Column(name = "bonus feats")
    public ArrayList<String> bonusFeats;

    @Column(name = "default feats")
    public ArrayList<String> defaultFeats;

    @Column(name = "race traits")
    public ArrayList<String> specialAbilities;
}
