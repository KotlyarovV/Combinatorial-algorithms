package CombinatoricAlgoritms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Vitaly on 25.02.2017.
 */
public class TwoParts {

    private static ArrayList<GraphVertex> part1 = new ArrayList<>();

    public static ArrayList<GraphVertex> getPart1() {
        return part1;
    }

    private static ArrayList<GraphVertex> part2 = new ArrayList<>();

    public static ArrayList<GraphVertex> getPart2() {
        return part2;
    }

    private static boolean incidentsInPart(ArrayList<GraphVertex> part, GraphVertex<Integer> graphVertex) {
        for (GraphVertex a : graphVertex.linked)
            if (part.contains(a))
                return true;
        return false;
    }

    private static ArrayList<GraphVertex> allParts() {
        ArrayList<GraphVertex> allParts = new ArrayList<>();
        allParts.addAll(part1);
        allParts.addAll(part2);
        return allParts;
    }

    private static void BFS (Graph graph) {
        Queue<GraphVertex> queue = new LinkedList<>();
        queue.offer(graph.startVertex);
        part1.add(graph.startVertex);
        graph.startVertex.visited = true;

        while (! queue.isEmpty()) {
            GraphVertex<Integer> node = queue.poll();
            for (GraphVertex<Integer> graphVertex: node.linked) {
                if (!graphVertex.visited) {
                    queue.offer(graphVertex);
                    graphVertex.visited = true;
                    if (incidentsInPart(part1, graphVertex)) {
                        part2.add(graphVertex);
                    }
                    else part1.add(graphVertex);
                }
            }
        }
    }

    public static boolean checkGraph  (Graph graph) {
        BFS(graph);
        for (GraphVertex graphVertex : allParts())
              if (incidentsInPart(part1, graphVertex) && incidentsInPart(part2,graphVertex))
                return false;
        return true;
    }
}
