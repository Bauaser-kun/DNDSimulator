package dnd.simulator.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dnd.simulator.creatures.CharacterClass;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class DbInitialSetup {
    @Autowired
    ClassRepository repository;

    public boolean addClassesToDatabase(){
        boolean result = false;

        try { 
            ClassLoader classLoader = getClass().getClassLoader(); 
            BufferedReader reader = new BufferedReader(new FileReader(new File(classLoader.getResource("defaultClasses.csv").toURI())));
            String line = reader.readLine();

            while (line != null) {
                String[] atributes = line.split(",");
                CharacterClass classToSave = createClassToSave(atributes);
                repository.save(classToSave);
            }

            result = true;
            reader.close();
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    private CharacterClass createClassToSave(String[] atributes) {
        String className = atributes[0];
        ArrayList<String> roles = new ArrayList<String>(Arrays.asList(atributes[1].split(" ")));
        boolean isSpellcaster = Boolean.valueOf(atributes[2]);
        String spellAtribute = atributes[3];
        boolean hasLimitedSpellsCount = Boolean.valueOf(atributes[4]);
        int hitDice = Integer.valueOf(atributes[5]);
        ArrayList<String> importantAtributes = new ArrayList<String>(Arrays.asList(atributes[6].split(" ")));
        
        return new CharacterClass(className, roles, isSpellcaster, spellAtribute, hasLimitedSpellsCount, hitDice, importantAtributes);
    }
}
