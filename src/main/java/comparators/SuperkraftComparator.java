package comparators;

import domain.Superhero;

import java.util.Comparator;

public class SuperkraftComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero d1, Superhero d2) {
        return d1.getSuperkraft().compareTo(d2.getSuperkraft());
    }
}