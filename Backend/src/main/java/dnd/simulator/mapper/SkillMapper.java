package dnd.simulator.mapper;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dnd.simulator.creatures.skills.Skill;
import dnd.simulator.dto.SkillDto;

@Service
public class SkillMapper {
    public ArrayList<SkillDto> mapToSkillDtoList(ArrayList<Skill> skills) {
        return (ArrayList<SkillDto>) skills.stream().map(this::mapToSkillDto).collect(Collectors.toList());
    }
    
    public ArrayList<Skill> mapToFeatList(ArrayList<SkillDto> skillDtos) {
        return (ArrayList<Skill>) skillDtos.stream().map(this::mapToSkill).collect(Collectors.toList());
    }

    public SkillDto mapToSkillDto(Skill skill) {
        return new SkillDto(skill.getSkillName(), skill.getRank(), skill.getMaxRank(), skill.getRevelantAtribute());
    }

    public Skill mapToSkill(SkillDto skillDto) {
        return null;
    }
}
