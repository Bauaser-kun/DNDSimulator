package dnd.simulator.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dnd.simulator.creatures.feats.Feat;
import dnd.simulator.creatures.feats.FeatPrerequisite;
import dnd.simulator.dto.FeatDto;
import dnd.simulator.dto.FeatPrerequisiteDto;

@Service
public class FeatMapper {
    @Autowired
    SkillMapper skillMapper;

    public List<FeatDto> mapToFeatDtoList(List<Feat> feats) {
        return feats.stream().map(this::mapToFeatDto).collect(Collectors.toList());
    }
    
    public List<Feat> mapToFeatList(List<FeatDto> featDtos) {
        return featDtos.stream().map(this::mapToFeat).collect(Collectors.toList());
    }

    public FeatDto mapToFeatDto(Feat feat) {
        return new FeatDto(feat.getFeatName(), feat.getType(), mapToFeatPrerequisite(feat.getPrerequesites()), feat.getBenefit(), 
        feat.getNormal(), feat.getSpecial(), feat.getMaxCount(), feat.getBonusFor());
    }

    private FeatPrerequisiteDto mapToFeatPrerequisite(FeatPrerequisite prerequesite) {
        return new FeatPrerequisiteDto(prerequesite.getStrength(), prerequesite.getDexterity(), prerequesite.getConstitution(), 
        prerequesite.getIntelligence(), prerequesite.getWisdom(), prerequesite.getCharisma(), 
        prerequesite.getFeats(), prerequesite.getSpecial(), prerequesite.getBaseAttack(), skillMapper.mapToSkillDtoList(prerequesite.getSkills()),prerequesite.getClassLevels());
    }

    public Feat mapToFeat(FeatDto featDto) {
        return null;
    }

}
