package dnd.simulator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SkillDto {
    private String skillName;
    private double rank;
    private double maxRank;
    private String revelantAtribute;
}
