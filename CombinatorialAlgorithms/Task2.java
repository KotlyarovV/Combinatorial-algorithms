package CombinatoricAlgoritms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaly on 05.03.2017.
 */
public class Task2 {

    public static void main(String[] args) throws IOException {
        //task 2 поиск пути
        Graph<Coordinates> graph = new Graph<>();
        List<String> lines = Util.getParams("inputTask2");

        //получение длины и ширины поля
        int height = Util.stringToIntegers(lines.get(0)).get(0);
        lines.remove(0);
        int width = Util.stringToIntegers(lines.get(0)).get(0);
        lines.remove(0);
        int[][] numbers = new int[height][width];

        //получение начала и конца пути
        ArrayList<Integer> endCoords = Util.stringToIntegers(lines.get(lines.size() - 1));
        Coordinates end = new Coordinates(endCoords.get(0),endCoords.get(1));
        lines.remove(lines.size() - 1);

        ArrayList<Integer> beginCoords = Util.stringToIntegers(lines.get(lines.size() - 1));
        Coordinates begin = new Coordinates(beginCoords.get(0),beginCoords.get(1));
        lines.remove(lines.size() - 1);
        graph.addVertex(begin);

        //занесение в массив
        for (int i = 0; i < lines.size(); i++) {
            String numbersString = lines.get(i);
            ArrayList<Integer> ints = Util.stringToIntegers(numbersString);
            for (int j = 0; j < ints.size(); j++)
                numbers[i][j] = ints.get(j);
        }

        for (int i = 0; i < numbers.length; i++)
            for (int j = 0; j < numbers[i].length; j++)
                if (numbers[i][j] == 0 && !(i + 1 == begin.x && j + 1 == begin.y))
                        graph.addVertex(new Coordinates(i + 1, j + 1));

        for (Coordinates coordinates : graph.vertexHashMap.keySet())
            for (Coordinates coordinatesIn : graph.vertexHashMap.keySet())
                if (coordinates.inNeighbors(coordinatesIn))
                    graph.addLinkeds(coordinates, coordinatesIn);

        Labirinth labirinth = new Labirinth();
        labirinth.findWay(graph, end);

        String result = labirinth.finded ? "Y" : "N";
        result = result +"\n";

        if (labirinth.finded)
            for (Object coordinates : labirinth.getWay())
                result = result +coordinates.toString() + "\n";

        Util.writeToFile(result, "resultTask2");
    }
}
