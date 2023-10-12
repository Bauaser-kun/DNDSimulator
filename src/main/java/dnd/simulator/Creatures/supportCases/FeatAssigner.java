package dnd.simulator.creatures.supportCases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dnd.simulator.creatures.Creature;
import dnd.simulator.creatures.feats.Feat;

@Service
@Transactional
public class FeatAssigner {
    public Creature assignFeats(Creature creature, List<Feat> feats) {
        feats.forEach(feat -> {
            if (checkPrerequesites(creature, feat)) {

            }
        });

        return creature;
    }

    private boolean checkPrerequesites(Creature creature, Feat feat) {
        boolean meetsPrerequesites = true;

        feat.getPrerequesites().forEach(prerequesite -> {
            boolean thisPrerequesiteIsMet;
            
            if (prerequesite.startsWith("feat: ")){
                List<String> featNames = creature.getFeats().stream()
                .map(Feat::getFeatName)
                .collect(Collectors.toList());
                
                thisPrerequesiteIsMet = featNames.contains(prerequesite.substring(6));
            }

            meetsPrerequesites = thisPrerequesiteIsMet;
        });
        
        return meetsPrerequesites;
    }
    
}
