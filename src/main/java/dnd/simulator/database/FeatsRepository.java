package dnd.simulator.database;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dnd.simulator.creatures.feats.Feat;

@Transactional
@Repository
public interface FeatsRepository extends CrudRepository<Feat, String> {
    Optional<Feat> findById(String featName);

    List<Feat> findByType(String type);
    
    List<Feat> findByMaxCount(int maxCount);

    List<Feat> findByBonusFor(ArrayList<String> bonusFor);

    List<Feat> findAll();
}
