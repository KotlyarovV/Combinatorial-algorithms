package CombinatoricAlgoritms;

import java.util.*;

/**
 * Created by Vitaly on 26.02.2017.
 */
public class Labirinth <T>{

    private T end;
    private Stack<GraphVertex> stack = new Stack<>();
    private int checker = 0;
    private int vertexesInGraph;
    public boolean finded = false;

    public void findWay (Graph graph, T end) {
        this.end = end;
        vertexesInGraph = graph.vertexHashMap.size();
        DFS(graph.startVertex);
    }

    public void DFS ( GraphVertex<T> graphVertex) {
        graphVertex.visited = true;

        if (!finded) stack.add(graphVertex);
        checker ++;

        if (graphVertex.number.equals(end)) {
            finded = true;
            return;
        }

        if (checker == vertexesInGraph) return;

        if (graphVertex.allLinkedsAreVisited())
            while (stack.peek().allLinkedsAreVisited())
                    stack.pop();

        for (GraphVertex graphVertexChild :  graphVertex.linked)
            if (!graphVertexChild.visited)
                DFS(graphVertexChild);
    }

    public ArrayList<T> getWay () {

        ArrayList<T> resultList = new ArrayList<T>();
        ArrayList<GraphVertex<T>> arrayList = new ArrayList<GraphVertex<T>>();

        while (!stack.empty())
            arrayList.add(stack.pop());

        Collections.reverse(arrayList);

        for (GraphVertex graphVertex : arrayList)
            resultList.add((T) graphVertex.number);

        return resultList;
    }

}
