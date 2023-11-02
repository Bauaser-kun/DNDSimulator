package dnd.simulator.database;

import java.util.List;
import java.util.Optional;

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

    public List<Feat> getFeatsOfType(String featType) {
        return featsRepository.findByType(featType);
    }

    public List<Feat> getMultiCountFeats(int maxCount) {
        return featsRepository.findByMaxCount(maxCount);
    }

    public List<Feat> getSingleChoseFeats() {
        return featsRepository.findByMaxCount(1);
    }

    public Optional<Feat> getFeat(String featName) {
        return featsRepository.findById(featName);
    }

    public void deleteFeat(String featName) {
        featsRepository.deleteById(featName);
    }

    public Feat saveFeat(Feat feat) {
        return featsRepository.save(feat);
    }
}
