package comparators;

import domain.Superhero;

import java.util.Comparator;

public class NavneComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero d1, Superhero d2) {
        return d1.getNavn().compareTo(d2.getNavn());
    }
}
