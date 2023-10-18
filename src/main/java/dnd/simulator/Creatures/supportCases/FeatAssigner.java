package dnd.simulator.creatures.supportCases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dnd.simulator.creatures.Creature;
import dnd.simulator.creatures.feats.Feat;
import dnd.simulator.creatures.feats.FeatPrerequisite;
import dnd.simulator.creatures.skills.Skill;

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
        FeatPrerequisite prerequisite = feat.getPrerequesites();
        List<String> creatureFeats = creature.getFeats().stream().map(Feat::getFeatName).toList();
        List<Skill> creatureSkills = creature.getSkills();
        boolean enoughAtributeScore = true;
        boolean allFeatsIncluded = creatureFeats.containsAll(prerequisite.getFeats());
        boolean baseAttackHighEnough = (prerequisite.getBaseAttack() <= creature.getBaseAttack());
        boolean allSkillsRankHighEnough = true;

        if (creature.getStrength() < prerequisite.getStrength() || creature.getDexterity() < prerequisite.getDexterity() ||
            creature.getConstitution() < prerequisite.getConstitution() || creature.getIntelligence() < prerequisite.getIntelligence() ||
            creature.getWisdom() < prerequisite.getWisdom() || creature.getCharisma() < prerequisite.getCharisma()) {
                enoughAtributeScore = false;
            }
        
        prerequisite.getSkills().forEach(requiredSkill -> {
            int index = IntStream.range(0, creatureSkills.size())
                .filter(i -> creatureSkills.get(i).getSkillName() == requiredSkill.getSkillName())
                .findFirst().getAsInt();

            if (creatureSkills.get(index).getRank() < requiredSkill.getRank()) {
                allSkillsRankHighEnough = false;
            }
        });
                
        return enoughAtributeScore && allFeatsIncluded && baseAttackHighEnough && allSkillsRankHighEnough;
    }
}
