package dnd.simulator.creatures.supportCases;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dnd.simulator.creatures.Creature;
import dnd.simulator.creatures.feats.Feat;
import dnd.simulator.creatures.supportCases.rolls.RollAssigner;
import io.micrometer.common.lang.Nullable;

@Service
@Transactional
public class Assigner {
    @Autowired
    RollAssigner rollAssigner;

    public Creature assignRolls(Creature creature, @Nullable String className, String rollsUsed, String role) {
        return rollAssigner.assignRolls(creature, className, rollsUsed, role);
    }

    public Creature assignFeats(Creature creature, List<Feat> feats) {
        return creature;
    }
}
