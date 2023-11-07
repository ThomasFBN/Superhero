package comparators;

import domain.Superhero;

import java.util.Comparator;

public class StyrkeComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero d1, Superhero d2) {
        return d1.getStyrke().compareTo(d2.getStyrke());
    }
}