import domain.Database;
import domain.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    private Database db;

    @BeforeEach
    void setUp() {
        db = new Database();
        db.addSuperhero("August", "aka mr mega kedelig", "dårlig til slope", 2002, true, "scabbers");
        db.addSuperhero("Jens", "sørenst", "mega lort til hearthstone", 2003, false, "scabbers");
        db.addSuperhero("Thomas", "Tog", "dræber selvtillid", 2002, false, "scabbers");
        db.addSuperhero("Joakim", "Banankagemanden", "bedste til alt", 2001, false, "iskoldt emil stabil");
    }

    @Test
    void addSuperhero() {
        int expected = db.getSuperheroes().size() + 1;
        db.addSuperhero("Joakim", "Banankagemanden", "bedste til alt", 2001, false, "iskoldt emil stabil");
        int actual = db.getSuperheroes().size();
        assertEquals(expected, actual);
    }

    @Test
    void addFlereSuperheroes() {
        int expected = db.getSuperheroes().size() + 3;
        db.addSuperhero("Joakim", "Banankagemanden", "bedste til alt", 2001, false, "iskoldt emil stabil");
        db.addSuperhero("Jens", "Bananmanden", "bedste til alt", 2001, false, "iskoldt emil stabil");
        db.addSuperhero("Liselotte", "Banankage", "bedste til alt", 2001, false, "iskoldt emil stabil");
        int actual = db.getSuperheroes().size();
        assertEquals(expected, actual);
    }

    @Test
    void searchForIngen() {
        ArrayList<Superhero> expected = new ArrayList<>(1);
        ArrayList<Superhero> actual = db.search("Dennis");
        assertEquals(expected, actual);

    }

    @Test
    void searchForSuperhero() {

        ArrayList<Superhero> results = db.search("Joakim");
        int expected = 1;
        int actual = results.size();

        assertEquals(expected, actual);
    }

    @Test
    void searchForFlereSuperhero() {

        ArrayList<Superhero> results = db.search("J");
        int expected = 2;
        int actual = results.size();

        assertEquals(expected, actual);
    }

    @Test
    void deleteSuperhero() {


        int expected = db.getSuperheroes().size() - 1;
        db.deleteSuperhero("August");
        int actual = db.getSuperheroes().size();

        assertEquals(expected, actual);
    }
}