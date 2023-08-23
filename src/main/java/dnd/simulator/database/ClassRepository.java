package dnd.simulator.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dnd.simulator.creatures.CharacterClass;

@Repository
@Transactional
public interface ClassRepository extends CrudRepository<CharacterClass, String> {
    List<CharacterClass> findByIsSpellcaster(boolean isSpellcaster);
}
