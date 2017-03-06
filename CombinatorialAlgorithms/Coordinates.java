package CombinatoricAlgoritms;

import java.util.ArrayList;

/**
 * Created by Vitaly on 26.02.2017.
 */
public class Coordinates {

    public Integer x;
    public Integer y;

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public boolean inNeighbors (Coordinates coordinates) {
        ArrayList<Coordinates> coordinatss = new ArrayList<>();

        coordinatss.add(new Coordinates(this.x + 1, this.y));
        coordinatss.add(new Coordinates(this.x - 1, this.y));
        coordinatss.add(new Coordinates(this.x, this.y + 1));
        coordinatss.add(new Coordinates(this.x, this.y - 1));

        return coordinatss.contains(coordinates);
    }

    @Override
    public int hashCode() {
       return Integer.parseInt(Integer.toString(x.hashCode()) + "0" + Integer.toString(y.hashCode()));
    }

    @Override
    public boolean equals (Object o) {
        return o instanceof Coordinates && o.hashCode() == this.hashCode();
    }

    @Override
    public String toString () {
        return x.toString() + " " + y.toString();
    }
}
