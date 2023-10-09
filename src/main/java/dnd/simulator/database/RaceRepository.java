package dnd.simulator.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dnd.simulator.creatures.Race.Race;

@Transactional
@Repository
public interface RaceRepository extends CrudRepository<Race, String> {
    Optional<Race> findById(String name);
}
