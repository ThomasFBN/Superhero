package comparators;

import domain.Superhero;

import java.util.Comparator;

public class OprettelsesÅrComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero d1, Superhero d2) {
        return Integer.compare(d1.getOprettelsesÅr(),d2.getOprettelsesÅr());
    }
}
