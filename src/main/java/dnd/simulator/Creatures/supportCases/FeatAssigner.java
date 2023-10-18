package dnd.simulator.creatures.supportCases;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dnd.simulator.creatures.Creature;
import dnd.simulator.creatures.feats.Feat;
import dnd.simulator.creatures.feats.FeatPrerequesite;

@Service
@Transactional
public class FeatAssigner {
    public Creature assignFeats(Creature creature, List<Feat> feats) {
        ArrayList<Feat> creatureFeats = creature.getFeats();

        feats.forEach(feat -> {
            if (checkPrerequesites(creature, feat)) {
                creatureFeats.add(feat);
            }
        });

        creature.setFeats(creatureFeats);
        return creature;
    }

    private boolean checkPrerequesites(Creature creature, Feat feat) {
        FeatPrerequesite prerequesite = feat.getPrerequesites();
        List<String> creatureFeats = creature.getFeats().stream().map(Feat::getFeatName).toList();
        boolean enoughAtributeScore = true;
        boolean allFeatsIncluded = creatureFeats.containsAll(prerequesite.getFeats());

        if (creature.getStrength() < prerequesite.getStrength() || creature.getDexterity() < prerequesite.getDexterity() ||
            creature.getConstitution() < prerequesite.getConstitution() || creature.getIntelligence() < prerequesite.getIntelligence() ||
            creature.getWisdom() < prerequesite.getWisdom() || creature.getCharisma() < prerequesite.getCharisma()) {
                enoughAtributeScore = false;
            }
                
        return enoughAtributeScore && allFeatsIncluded;
    }
}
