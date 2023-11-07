import comparators.NavneComparator;
import comparators.ÆgteNavnComparator;
import domain.Database;
import domain.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    private Database db;

    @BeforeEach
    public void setUp() {
        db = new Database();
        db.createSuperhero("August", "aka mr mega kedelig", "dårlig til slope", 2002, true, "scabbers");
        db.createSuperhero("Jens", "sørenst", "mega lort til hearthstone", 2003, false, "scabbers");
        db.createSuperhero("Thomas", "Tog", "dræber selvtillid", 2002, false, "scabbers");
        db.createSuperhero("Joakim", "Banankagemanden", "bedste til alt", 2001, false, "iskoldt emil stabil");
    }

    @Test
   public void addSuperhero() {
        int expected = db.getSuperheroes().size() + 1;
        db.createSuperhero("Joakim", "Banankagemanden", "bedste til alt", 2001, false, "iskoldt emil stabil");
        int actual = db.getSuperheroes().size();
        assertEquals(expected, actual);
    }

    @Test
    public void addFlereSuperheroes() {
        int expected = db.getSuperheroes().size() + 3;
        db.createSuperhero("Joakim", "Banankagemanden", "bedste til alt", 2001, false, "iskoldt emil stabil");
        db.createSuperhero("Jens", "Bananmanden", "bedste til alt", 2001, false, "iskoldt emil stabil");
        db.createSuperhero("Liselotte", "Banankage", "bedste til alt", 2001, false, "iskoldt emil stabil");
        int actual = db.getSuperheroes().size();
        assertEquals(expected, actual);
    }

    @Test
    public void searchForIngen() {
        ArrayList<Superhero> expected = new ArrayList<>(1);
        ArrayList<Superhero> actual = db.search("Dennis");
        assertEquals(expected, actual);

    }

    @Test
    public void searchForSuperhero() {

        ArrayList<Superhero> results = db.search("Joakim");
        int expected = 1;
        int actual = results.size();

        assertEquals(expected, actual);
    }

    @Test
    public void searchForFlereSuperhero() {

        ArrayList<Superhero> results = db.search("J");
        int expected = 2;
        int actual = results.size();

        assertEquals(expected, actual);
    }

    @Test
    public void deleteSuperhero() {


        int expected = db.getSuperheroes().size() - 1;
        db.deleteSuperhero("August");
        int actual = db.getSuperheroes().size();

        assertEquals(expected, actual);
    }
    @Test
    public void testSortering() {
        // Arrange
        db.sortering(1, 2); // Sortér primært efter navn, sekundært efter ægte navn

        // Act
        ArrayList<Superhero> sortedSuperheroes = db.getSuperheroes();

        // Assert

        Comparator<Superhero> testComperator = new NavneComparator().thenComparing(new ÆgteNavnComparator());
        Collections.sort(sortedSuperheroes, testComperator);

        assertEquals(sortedSuperheroes, db.getSuperheroes());
    }
}