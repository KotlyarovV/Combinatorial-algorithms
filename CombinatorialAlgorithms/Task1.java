package CombinatoricAlgoritms;

import java.io.*;
import java.util.*;

public class Task1 {

    public static void main(String[] args) throws IOException {
        //task 1 проверка графа на двудольность
        Graph<Integer> graph = new Graph<>();
        List<String> lines = Util.getParams("input");
        lines.remove(0);
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            String numbers = lines.get(i);
            arrayLists.add(Util.stringToIntegersWithoutZero(numbers));
        }

        for (int i = 0; i < arrayLists.size(); i++) {
            graph.addVertex(i+1);
            for (int j = 0; j< arrayLists.get(i).size(); j++) {
                graph.addLinkeds(i+1, arrayLists.get(i).get(j));
            }
        }

        boolean yesOrNow = TwoParts.checkGraph(graph);

        String result = yesOrNow ? "Y" : "N";
        result = result + "\n";

        if (yesOrNow) {
            for (GraphVertex vertes : TwoParts.getPart1())
                result = result + vertes.toString()+" ";
            result = result + "\n0\n";
            for (GraphVertex vertes : TwoParts.getPart2())
                result = result + vertes.toString()+" ";
        }

        Util.writeToFile(result, "result");
    }
}