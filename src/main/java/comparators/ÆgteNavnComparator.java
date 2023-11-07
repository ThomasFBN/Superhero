package comparators;

import domain.Superhero;

import java.util.Comparator;

public class ÆgteNavnComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero d1, Superhero d2) {
        return d1.getÆgteNavn().compareTo(d2.getÆgteNavn());
    }
}