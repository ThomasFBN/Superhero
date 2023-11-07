package comparators;

import domain.Superhero;

import java.util.Comparator;

public class ErMenneskeComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero d1, Superhero d2) {
        return Boolean.compare(d1.getErMenneske(),d2.getErMenneske());
    }
}