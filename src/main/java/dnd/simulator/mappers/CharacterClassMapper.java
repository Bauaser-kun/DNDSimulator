package dnd.simulator.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dnd.simulator.creatures.characterClasses.CharacterClass;
import dnd.simulator.creatures.characterClasses.CharacterClassDto;

@Service
public class CharacterClassMapper {
    public CharacterClass mapToClass(final CharacterClassDto characterClassDto) {
        return new CharacterClass(
            characterClassDto.getClassName(),
            characterClassDto.getRoles(),
            characterClassDto.getImportantAtributes(),
            characterClassDto.isSpellcaster(),
            characterClassDto.getSpellAtribute(),
            characterClassDto.isHasLimitedSpellsCount(),
            characterClassDto.getHitDice());
    }

    public CharacterClassDto mapToClassDto(final CharacterClass characterClass) {
        return new CharacterClassDto(
            characterClass.getClassName(),
            characterClass.getRoles(),
            characterClass.getImportantAtributes(),
            characterClass.isSpellcaster(),
            characterClass.getSpellAtribute(),
            characterClass.isHasLimitedSpellsCount(),
            characterClass.getHitDice());
    }

    public List<CharacterClassDto> mapToTaskDtoList(final List<CharacterClass> classList) {
      return classList.stream()
               .map(this::mapToClassDto)
               .collect(Collectors.toList());
    }

    public List<CharacterClass> mapToClassList(final List<CharacterClassDto> classDtoList) {
        return classDtoList.stream()
            .map(this::mapToClass)
            .collect(Collectors.toList());
    }
}
