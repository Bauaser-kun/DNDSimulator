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

    @Column(name = "featType")
    public String type;

    @Column(name = "prerequesites")
    public FeatPrerequesite prerequesites;

    @Column(name = "benefit")
    public String benefit;

    @Column(name = "normal")
    public String normal;

    @Column(name = "special")
    public String special;

    @Column(name = "max aquired count")
    public int maxCount;

    @Column(name = "bonus for")
    public ArrayList<CharacterClass> bonusFor;
}
