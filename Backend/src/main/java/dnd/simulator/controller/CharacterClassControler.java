package dnd.simulator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dnd.simulator.creatures.characterClasses.CharacterClass;
import dnd.simulator.creatures.characterClasses.CharacterClassDto;
import dnd.simulator.database.DBService;
import dnd.simulator.mapper.CharacterClassMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/classes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CharacterClassControler {
    private final DBService dbService;
    private final CharacterClassMapper classMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getCharacterClasses")
    public List<CharacterClassDto> getCharacterClases() {
        List<CharacterClass> characterClasses = dbService.getAllCharacterClasses();
        return classMapper.mapToTaskDtoList(characterClasses);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCharacterClass")
    public CharacterClassDto getCharacterClass(String className) {
        return new CharacterClassDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCharacterClass")
    public void deleteCharacterClass(String className) {
  
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCharacterClass")
    public CharacterClassDto updateCharacterClass(CharacterClassDto characterClassDto) {
        return new CharacterClassDto();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCharacterClass")
    public void createCharacterClass(CharacterClassDto characterClassDto) {
  
    }
}
