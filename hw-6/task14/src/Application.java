import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) {

        List<List<String>> id = fillSet("путь для файла с айдишниками фильмов и названиями");
        List<List<String>>  history = fillSet("путь для файла с историей просмотров");

        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.next().split(",");
        List<Integer> data = new ArrayList<>(); //ввод данных
        for (int i = 0; i < s.length; ++i) {
            int n = Integer.parseInt(s[i]);
            data.add(n);
        }


    }


    static List<List<String>> fillSet (String path) {
        List<List<String>> fileData = new ArrayList<>();

        try (FileReader reader = new FileReader(path);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) { //считывание строчки в файле
                List<String> dataString = new ArrayList<>();
                line = line.trim();
                String[] info = line.split(","); //считываем каждое значение в строке
                for (int i = 0; i < info.length; ++i) {
                    dataString.add(info[i]);
                }
                fileData.add(dataString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileData;
    }

    static List<String> findNeighbour (List<Integer> d, List<List<String>> neigh) {


    }
}
