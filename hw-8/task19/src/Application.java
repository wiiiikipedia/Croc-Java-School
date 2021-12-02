import javax.swing.*;
import java.awt.*;

public class Application {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        JFrame window = new JFrame("Task 19");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //программа перестает работать при нажатии на крестик

        JTextField text = new JTextField();
        text.setText("Hello world!");

        Font font = new Font("TimesRoman", Font.BOLD, 30);
        text.setFont(font);

        window.getContentPane().add(text);

        window.setLocationRelativeTo(null);
        window.pack();
        window.setVisible(true);
    }
}
