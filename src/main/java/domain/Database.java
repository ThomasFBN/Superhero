package domain;

import java.util.ArrayList;

public class Database {
    ArrayList<Superhero> superhelteListe = new ArrayList<>();

    public void addSuperhero(String navn, String ægteNavn, String superKræft, int oprettelsesÅr, boolean erMenneske, String styrke) {
        superhelteListe.add(new Superhero(navn, ægteNavn, superKræft, oprettelsesÅr, erMenneske, styrke));
    }

    public void printAntalSuperhelte() {
        System.out.println(superhelteListe.size());
    }

    public void printAlleSuperhero() {
        for (Superhero superhelt : superhelteListe) {
            System.out.println(superhelt);
        }
        System.out.println("Antal superhelte: " + superhelteListe.size());
    }

    public ArrayList<Superhero> search(String søgeOrd) {
        ArrayList<Superhero> søgeResultat = new ArrayList<>();
        for (Superhero superhero : superhelteListe) {
            String name = superhero.getNavn().toLowerCase();
            if (name.contains(søgeOrd.toLowerCase())) {
                søgeResultat.add(superhero);
            }
        }
        return søgeResultat;
    }

    public void editSuperhero(String superheroName, String nytNavn, String nytÆgteNavn, String nySuperKræft, int nytOprettelsesÅr, boolean erNytMenneske, String nyStyrke) {
        ArrayList<Superhero> søgeResultat = search(superheroName);

        if (!søgeResultat.isEmpty()) {
            Superhero superhelt = søgeResultat.get(0); // Get the first superhero in the search result

            superhelt.setNavn(nytNavn);
            superhelt.setÆgteNavn(nytÆgteNavn);
            superhelt.setSuperKræft(nySuperKræft);
            superhelt.setOprettelsesÅr(nytOprettelsesÅr);
            superhelt.setErMenneske(erNytMenneske);
            superhelt.setStyrke(nyStyrke);

            System.out.println("Superhelt opdateret: " + superhelt);
        } else {
            System.out.println("Superhelten med navnet '" + superheroName + "' blev ikke fundet.");
        }

    }

    public void deleteSuperhero(String superheroName) {
        ArrayList<Superhero> søgeResultat = search(superheroName);

        if (!søgeResultat.isEmpty()) {
            Superhero superhelt = søgeResultat.get(0);
            superhelteListe.remove(superhelt);
            System.out.println("Superhelten '" + superheroName + "' er blevet slettet.");
        } else {
            System.out.println("Superhelten med navnet '" + superheroName + "' blev ikke fundet.");
        }
    }


    public ArrayList<Superhero> getSuperheroes() {
        return superhelteListe;
    }

}
