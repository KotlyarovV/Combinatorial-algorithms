package CombinatoricAlgoritms;

import java.util.HashMap;

/**
 * Created by Vitaly on 24.02.2017.
 */
public class Graph <T>{

   public  HashMap<T,GraphVertex<T>> vertexHashMap = new HashMap<>();
   public GraphVertex<T> startVertex;

   public void addVertex (T a) {
       if (vertexHashMap.get(a) == null) {
           GraphVertex<T> graphVertex = new GraphVertex<>(a);
           vertexHashMap.put(a, graphVertex);
           if (startVertex == null)
               startVertex = graphVertex;
       }
   }

   public void addLinkeds (T a, T b) {
        if (vertexHashMap.get(b) == null) {
            addVertex(b);
            vertexHashMap.get(a).addLinked(vertexHashMap.get(b));
        }
        else if (vertexHashMap.get(a).linked.contains(vertexHashMap.get(b)))
            return;
        else vertexHashMap.get(a).addLinked(vertexHashMap.get(b));
   }
}
