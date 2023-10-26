package dnd.simulator.creatures.skills;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "skills")
public class Skill {
    @Id
    @Column(name = "skill")
    private String skillName;
    
    @Column(name =  "rank")
    private double rank;

    @Column(name = "maxRank")
    private double maxRank;

    @Column(name = "atribute")
    private String revelantAtribute;
}
