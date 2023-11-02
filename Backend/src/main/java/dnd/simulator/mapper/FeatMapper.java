package dnd.simulator.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dnd.simulator.creatures.feats.Feat;
import dnd.simulator.creatures.feats.FeatDto;

@Service
public class FeatMapper {

    public List<FeatDto> mapToFeatDtoList(List<Feat> feats) {
        return feats.stream().map(this::mapToFeatDto).collect(Collectors.toList());
    }
    
    public List<Feat> mapToFeatList(List<FeatDto> featDtos) {
        return featDtos.stream().map(this::mapToFeat).collect(Collectors.toList());
    }

    public FeatDto mapToFeatDto(Feat feat) {
        return new FeatDto(feat.getFeatName(), feat.getType(), feat.getPrerequesites(), feat.getBenefit(), 
        feat.getNormal(), feat.getSpecial(), feat.getMaxCount(), feat.getBonusFor());
    }

    public Feat mapToFeat(FeatDto featDto) {
        return null;
    }

}
