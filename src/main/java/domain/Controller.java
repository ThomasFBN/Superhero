package domain;

import java.util.ArrayList;

public class Controller {
    private Database database;

    public Controller() {
        database = new Database();

    }

    public ArrayList<Superhero> search(String søgeord) {
        return database.search(søgeord);
    }

    public void printAntalSuperhero() {
        database.printAntalSuperhero();
    }

    public void printAlleSuperhero() {
        database.printAlleSuperhero();
    }

    public void deleteSuperhero(String superheroName) {
        database.deleteSuperhero(superheroName);
    }

    public void editSuperhero(String superheroName, String nytNavn, String nytÆgteNavn, String nySuperKræft, int nytOprettelsesÅr, boolean erNytMenneske, String nyStyrke) {
        database.editSuperhero(superheroName, nytNavn, nytÆgteNavn, nySuperKræft, nytOprettelsesÅr, erNytMenneske, nyStyrke);
    }

    public void addSuperhero(String navn, String ægteNavn, String superKræft, int oprettelsesÅr, boolean erMenneske, String styrke) {
        database.addSuperhero(navn, ægteNavn, superKræft, oprettelsesÅr, erMenneske, styrke);
    }

}
