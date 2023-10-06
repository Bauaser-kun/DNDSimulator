package dnd.simulator.creatures.feats;

import java.util.ArrayList;

import dnd.simulator.creatures.CharacterClass;
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
@Table(name = "feats")
public class Feat {
    @Id
    @Column(name = "feat")
    public String featName;

    @Column(name = "prerequesites")
    public ArrayList<String> prerequesites;

    @Column(name = "description")
    public String description;

    @Column(name = "max aquired count")
    public int maxCount;

    @Column(name = "bonus for")
    public ArrayList<CharacterClass> bonusFor;
}