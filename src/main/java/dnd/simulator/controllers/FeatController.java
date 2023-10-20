package dnd.simulator.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dnd.simulator.creatures.feats.Feat;
import dnd.simulator.creatures.feats.FeatDto;
import dnd.simulator.database.DBService;
import dnd.simulator.mappers.FeatMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/classes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FeatController {
    private final DBService dbService;
    private final FeatMapper featMapper;
    
    @RequestMapping(method = RequestMethod.GET, value = "getFeats")
    public List<FeatDto> getAllFeats() {
        List<Feat> feats = dbService.getAllFeats();
        return featMapper.mapToFeatDtoList(feats);
    }
}


/*
import org.springframework.web.bind.annotation.RequestMethod;

    @RequestMapping(method = RequestMethod.GET, value = "getCharacterClasses")

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
*/