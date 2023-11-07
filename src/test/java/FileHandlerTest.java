import datasource.FileHandler;
import domain.Database;

import domain.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class FileHandlerTest {
    private Database database;
    private FileHandler fileHandler;
private ArrayList<Superhero> superheroes;
    @BeforeEach
    public void setUp() {
        superheroes = new ArrayList();
        database = new Database();
        fileHandler = new FileHandler("SuperheroTestData.csv");
    }

    @Test
    public void LoadSuperhero() throws IOException {
        superheroes = fileHandler.loadSuperhero();

        assertEquals(9,superheroes.size());

    }

}


