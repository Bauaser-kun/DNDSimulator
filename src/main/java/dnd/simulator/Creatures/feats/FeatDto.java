package dnd.simulator.creatures.feats;

import java.util.ArrayList;

import dnd.simulator.creatures.CharacterClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FeatDto {
    public String featName;

    public ArrayList<String> prerequesites;

    public String description;

    public int maxCount;

    public ArrayList<CharacterClass> bonusFor;
}
