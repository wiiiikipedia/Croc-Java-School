import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Application {
    public static void main(String[] args) {

        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Program expect 1 argument!");
        }
        String path = args[0];

        //try (FileReader reader = new FileReader("C:\\Users\\Acer\\IdeaProjects\\croc-1\\hw-4\\firstTask\\src\\text.txt");
        try (FileReader reader = new FileReader(path);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                line = line.trim();
                String[] s = line.split("[ ,.?!@#$%^&*()№:;]");
                //лучше .split("\\W") но это прям совсем какие-то читкоды не  уверена что можно юзать
                for (String str : s)
                    if (str != "" && !str.isEmpty()) ++count;

            }

            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
