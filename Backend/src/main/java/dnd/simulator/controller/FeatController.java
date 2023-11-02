package dnd.simulator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dnd.simulator.creatures.feats.Feat;
import dnd.simulator.creatures.feats.FeatDto;
import dnd.simulator.database.DBService;
import dnd.simulator.mapper.FeatMapper;
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

    @RequestMapping(method = RequestMethod.GET, value = "getFeat")
    public FeatDto getFeat(String featName) {
        return featMapper.mapToFeatDto(dbService.getFeat(featName).get());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteFeat")
    public void deleteFeat(String featName) {
        dbService.deleteFeat(featName);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateFeat")
    public FeatDto updateFeat(FeatDto featDto) {
        Feat feat = dbService.saveFeat(featMapper.mapToFeat(featDto));
        return featMapper.mapToFeatDto(feat);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createFeat")
    public void createFeat(FeatDto featDto) {
        dbService.saveFeat(featMapper.mapToFeat(featDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getSingleChoseFeats")
    public List<FeatDto> getSingleChoseFeats() {
        List<Feat> feats = dbService.getSingleChoseFeats();
        return featMapper.mapToFeatDtoList(feats);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getMulitpleChoseFeats")
    public List<FeatDto> getMultipleChoseFeats(int maxCount) {
        List<Feat> feats = dbService.getMultiCountFeats(maxCount);
        return featMapper.mapToFeatDtoList(feats);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getFeatsByType")
    public List<FeatDto> getFeatsByType(String type) {
        List<Feat> feats = dbService.getFeatsOfType(type);
        return featMapper.mapToFeatDtoList(feats);
    }
}
