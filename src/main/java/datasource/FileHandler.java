package datasource;

import domain.Database;
import domain.Superhero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    Database database;
    private File file = null;

    public FileHandler(String fileName){
        file = new File(fileName);
    }

    public void saveSuperhero(ArrayList<Superhero> superheroesList) {
        PrintStream output = null;
        try {
            //output = new PrintStream(new File("Superhero.csv"));
            output = new PrintStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Superhero superhero : superheroesList) {
            output.println(superhero.getNavn() + ";" +
                    superhero.getÆgteNavn() + ";" +
                    superhero.getSuperkraft() + ";" +
                    superhero.getOprettelsesÅr() + ";" +
                    superhero.getStyrke() + ";" +
                    superhero.getErMenneske());

        }
        System.out.println(database.getSuperheroes() + "names saved");
    }

    public ArrayList<Superhero> loadSuperhero() {
        ArrayList<Superhero> superheroData = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(file, StandardCharsets.ISO_8859_1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] attributes = line.split(";");

            String navn = attributes[0].trim();
            String ægteNavn = attributes[1].trim();
            String superKræft = attributes[2];
            int oprettelsesÅr = Integer.parseInt(attributes[3]);
            String styrke = attributes[4];
            boolean erMenneske = Boolean.parseBoolean(attributes[5]);


            Superhero superhero = new Superhero(navn, ægteNavn, superKræft, oprettelsesÅr, styrke, erMenneske);
            superheroData.add(superhero);

        }
        sc.close();
        return superheroData;
    }

}




