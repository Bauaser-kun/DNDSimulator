package dnd.simulator.database;

import java.util.List;

import org.springframework.stereotype.Service;

import dnd.simulator.creatures.characterClasses.CharacterClass;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DBService {
    private final ClassRepository classRepository;

    public List<CharacterClass> getAllCharacterClasses() {
        return classRepository.findAll();
    }
}
