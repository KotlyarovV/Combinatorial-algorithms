package CombinatoricAlgoritms;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Vitaly on 24.02.2017.
 */
public class GraphVertex <T>{

    public T number;
    public ArrayList<GraphVertex<T>> linked = new ArrayList<>();
    public boolean visited = false;

    public GraphVertex(T a) {
        number = a;
    }

    public void addLinked (GraphVertex<T> graphVertex) {
        graphVertex.linked.add(this);
        this.linked.add(graphVertex);
    }

    public boolean allLinkedsAreVisited () {
        for (GraphVertex graphVertex : linked)
            if (!graphVertex.visited)
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    public boolean equals(Objects objects) {
        return objects.hashCode() == number.hashCode();
    }

    @Override
    public String toString (){
        return number.toString();
    }

    public boolean isLinked (GraphVertex graphVertex) {
        return this.linked.contains(graphVertex);
    }

}
