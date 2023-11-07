package domain;

import comparators.*;
import datasource.FileHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Database {
    ArrayList<Superhero> superheroList = new ArrayList<>();
    private Comparator<Superhero> primaryComperator;
    private Comparator<Superhero> secondaryComperator;
    private FileHandler filehandler = new FileHandler("Superhero.csv");


    public void createSuperhero(String navn, String ægteNavn, String superKræft, int oprettelsesÅr, boolean erMenneske, String styrke) {
        superheroList.add(new Superhero(navn, ægteNavn, superKræft, oprettelsesÅr, styrke, erMenneske));
    }

    public void printAntalSuperhero() {
        System.out.println(superheroList.size());
    }

    public void printAlleSuperhero() {
        System.out.println("-------------------------------------------------");
        System.out.println("|             LISTE OVER SUPERHELTE             |");
        System.out.println("-------------------------------------------------");

        for (Superhero superhelt : superheroList) {
            System.out.println("-------------------------------------------------");
            System.out.println(superhelt);
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Antal superhelte: " + superheroList.size());
        System.out.println("-------------------------------------------------");
    }

    public ArrayList<Superhero> search(String søgeOrd) {
        ArrayList<Superhero> søgeResultat = new ArrayList<>();
        for (Superhero superhero : superheroList) {
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
            superhelt.setSuperkraft(nySuperKræft);
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
            superheroList.remove(superhelt);
            System.out.println("Superhelten '" + superheroName + "' er blevet slettet.");
        } else {
            System.out.println("Superhelten med navnet '" + superheroName + "' blev ikke fundet.");
        }
    }


    public ArrayList<Superhero> getSuperheroes() {
        return superheroList;
    }

    public void addSuperhero(Superhero superhero) {
        superheroList.add(superhero);
    }

    public void setPrimaryComperator(Comparator<Superhero> primaryComperator) {
        this.primaryComperator = primaryComperator;
    }

    public void setSecondaryComperator(Comparator<Superhero> secondaryComperator) {
        this.secondaryComperator = secondaryComperator;
    }

    public void sortering(int primary, int secondary) {
        switch (primary) {
            case 1: {
                setPrimaryComperator(new NavneComparator());
                break;
            }
            case 2: {
                setPrimaryComperator(new ÆgteNavnComparator());
                break;
            }
            case 3: {
                setPrimaryComperator(new SuperkraftComparator());
                break;
            }
            case 4: {
                setPrimaryComperator(new OprettelsesÅrComparator());
                break;
            }
            case 5: {
                setPrimaryComperator(new StyrkeComparator());
                break;
            }
            case 6: {
                setPrimaryComperator(new ErMenneskeComparator());
                break;
            }
        }

        switch (secondary) {
            case 1: {
                setSecondaryComperator(new NavneComparator());
                break;
            }
            case 2: {
                setSecondaryComperator(new ÆgteNavnComparator());
                break;
            }
            case 3: {
                setSecondaryComperator(new SuperkraftComparator());
                break;
            }
            case 4: {
                setSecondaryComperator(new OprettelsesÅrComparator());
                break;
            }
            case 5: {
                setSecondaryComperator(new StyrkeComparator());
                break;
            }
            case 6: {
                setSecondaryComperator(new ErMenneskeComparator());
            }
        }
    }

    public void compare() {
        Collections.sort(superheroList, primaryComperator.thenComparing(secondaryComperator));
    }

    public void saveSuperhero() {
        filehandler.saveSuperhero(superheroList);
    }

    public void loadSuperhero() {
        superheroList = filehandler.loadSuperhero();
    }
}


