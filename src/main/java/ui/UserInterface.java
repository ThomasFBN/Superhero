package ui;

import domain.Database;
import domain.Superhero;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    public static void startProgram() {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        int menuValg = 0;

        do {
            System.out.println("Velkommen til SUPERHERO UNIVERSET." +
                    "\nTast 1 for at oprette en ny superhelt." +
                    "\nTast 3 for at printe din superhelte-database" +
                    "\nTast 4 for at søge efter en oprettet superhelt" +
                    "\nTast 5 for at redigere i en oprettet superhelt" +
                    "\nTast 6 for at slette en superhelt" +
                    "\nTast 9 for at afslutte.");
            try {
                menuValg = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Fejl, tast et tal fra menuen");
                scanner.nextLine();
            }


            if (menuValg == 1) {

                System.out.println("Indtast navnet på din superhelt: ");
                String navn = scanner.nextLine();
                System.out.println("Indtast din superhelts rigtige navn: ");
                String ægteNavn = scanner.nextLine();
                System.out.println("Indtast superkræften på din superhelt: ");
                String superKræft = scanner.nextLine();
                System.out.println("Indtast superheltens creation year: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Du skal indtaste et tal: ");
                    scanner.nextLine();
                }
                int oprettelsesÅr = scanner.nextInt();

                scanner.nextLine();
                System.out.println("Indtast superheltens styrke: ");
                String styrke = scanner.nextLine();
                boolean erMenneske = true;
                char menneske;
                do {
                    System.out.println("Er superhelten menneske? (j/n): ");

                    menneske = scanner.next().charAt(0);

                    if (menneske == 'j') {
                        erMenneske = true;
                    } else if (menneske == 'n') {
                        erMenneske = false;
                    } else {
                        System.out.println("Ugyldigt input, indtast j/n");
                    }
                } while (menneske != 'j' && menneske != 'n');


                database.addSuperhero(navn, ægteNavn, superKræft, oprettelsesÅr, erMenneske, styrke);

            } else if (menuValg == 3) {
                database.printAlleSuperhero();
                System.out.println("Du har indtil videre oprettet så mange superhelte: ");
                database.printAntalSuperhelte();
            } else if (menuValg == 4) {
                System.out.println("Indtast navnet på superhelten, du vil søge efter: ");
                String superheroName = scanner.nextLine();
                ArrayList<Superhero> søgeResultat = database.search(superheroName);

                if (søgeResultat != null) {
                    System.out.println("Superhelt fundet:");
                    System.out.println(søgeResultat);
                } else {
                    System.out.println("Superhelten med navnet '" + superheroName + "' blev ikke fundet.");
                }
            } else if (menuValg == 5) {
                System.out.println("Indtast navnet på superhelten, du vil redigere: ");
                String superheroName = scanner.nextLine();
                ArrayList<Superhero> søgeEdit = database.search(superheroName);

                if (søgeEdit != null) {
                    System.out.println("Superhelt fundet:");
                    System.out.println(søgeEdit);
                    System.out.println("Indtast nye oplysninger for superhelten:");

                    // Indtast nye oplysninger og opdater superhelten
                    System.out.println("Indtast nyt navn: ");
                    String nytNavn = scanner.nextLine();
                    System.out.println("Indtast nyt ægte navn: ");
                    String nytÆgteNavn = scanner.nextLine();
                    System.out.println("Indtast ny superkræft: ");
                    String nySuperKræft = scanner.nextLine();
                    System.out.println("Indtast nyt oprettelsesår: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Du skal indtaste et tal: ");
                        scanner.nextLine();
                    }
                    int nytOprettelsesÅr = scanner.nextInt();
                    scanner.nextLine();

                    boolean erMenneske = true;
                    char menneske;
                    do {
                        System.out.println("Er superhelten menneske? (j/n): ");

                        menneske = scanner.next().charAt(0);
                        if (menneske == 'j') {
                            erMenneske = true;
                        } else if (menneske == 'n') {
                            erMenneske = false;
                        } else {
                            System.out.println("Ugyldigt input, indtast j/n");
                        }
                    } while (menneske != 'j' && menneske != 'n');

                    // Indtast nye styrke
                    scanner.nextLine();
                    System.out.println("Indtast ny styrke: ");
                    String nyStyrke = scanner.nextLine();

                    // Kald editSuperhero-metoden i databasen for at opdatere superhelten
                    database.editSuperhero(superheroName, nytNavn, nytÆgteNavn, nySuperKræft, nytOprettelsesÅr, erMenneske, nyStyrke);
                } else {
                    System.out.println("Superhelten med navnet '" + superheroName + "' blev ikke fundet.");
                }
            } else if (menuValg == 6) {
                System.out.println("Indtast navnet på superhelten, du vil slette: ");
                String superheroNameToDelete = scanner.nextLine();
                database.deleteSuperhero(superheroNameToDelete);
            }

        }
        while (menuValg != 9);
        System.out.println("System exit.");
    }
}
