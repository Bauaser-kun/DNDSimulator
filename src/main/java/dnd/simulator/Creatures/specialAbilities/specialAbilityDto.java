package dnd.simulator.creatures.specialAbilities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class specialAbilityDto {
    public String name;

    public String type;

    public String description;

    public String keyAtribute;

    public String source;

    public String savingThrow;
}
