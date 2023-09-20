package dnd.simulator.database;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DBService {
    private final ClassRepository classRepository;

}
