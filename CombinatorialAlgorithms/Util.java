package CombinatoricAlgoritms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Vitaly on 05.03.2017.
 */
public class Util {

    public static List<String> getParams(String fileName) throws IOException{
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file.getAbsoluteFile());
        BufferedReader reader = new BufferedReader(fileReader);
        List<String> list = new LinkedList<>();
        try {
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(s);
            }
        }
        catch (Throwable e) {}
        return list;
    }

    public static void writeToFile (String string, String fileName) throws IOException{
        Files.write(Paths.get("./" + fileName + ".txt"), string.getBytes());
    }

    public static ArrayList<Integer> stringToIntegers (String a) {
        Scanner scanner = new Scanner(a);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.hasNextInt())
                arrayList.add(scanner.nextInt());
            else scanner.hasNext();
        }
        scanner.close();
        return arrayList;
    }

    public static ArrayList<Integer> stringToIntegersWithoutZero(String a) {
        ArrayList<Integer> integerArrayList = stringToIntegers(a);
        Iterator<Integer> iter = integerArrayList.iterator();
        while (iter.hasNext()) {
            Integer n = iter.next();
             if (n.equals(0))
                 iter.remove();
        }
        return integerArrayList;
    }
}
