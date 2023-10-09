package dnd.simulator.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dnd.simulator.creatures.CharacterClass;

@Transactional
@Repository
public interface ClassRepository extends CrudRepository<CharacterClass, String> {
    Optional<CharacterClass> findById(String className);

    List<CharacterClass> findByIsSpellcaster(boolean isSpellcaster);

    List<CharacterClass> findBySpellAtribute(String spellAtribute);
}
