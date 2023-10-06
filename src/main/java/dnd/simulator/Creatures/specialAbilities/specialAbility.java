package dnd.simulator.creatures.specialAbilities;

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
@Table(name = "special abilities")
public class specialAbility {
    @Id
    @Column(name = "specialAbility")
    public String name;

    @Column(name = "type")
    public String type;

    @Column(name = "description")
    public String description;

    @Column(name = "atribute used")
    public String keyAtribute;

    @Column(name = "source")
    public String source;

    @Column(name = "saving throw")
    public String savingThrow;
}
