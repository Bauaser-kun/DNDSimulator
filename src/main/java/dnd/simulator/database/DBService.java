package dnd.simulator.database;

import java.util.List;

import org.springframework.stereotype.Service;

import dnd.simulator.creatures.feats.Feat;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DBService {
    private final ClassRepository classRepository;

    private final FeatsRepository featsRepository;

    public List<Feat> getAllFeats() {
        return featsRepository.findAll();
    }
}
