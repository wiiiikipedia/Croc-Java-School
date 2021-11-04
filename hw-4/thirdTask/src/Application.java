import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        String path = "log.txt";
        Peak p = new Peak(path);
        p.PrintMax();
    }
}
