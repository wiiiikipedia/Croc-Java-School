import java.util.Scanner;

public class Application {
    public static void main (String[] args) {
        System.out.print("Введите кол-во байт: ");
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        scanner.close();

        System.out.print("Результат: ");
        convertTo(n);
    }

    static void convertTo(double n) {
        int i = 0;
        while (n >= 1024) {
            ++i;
            n /= 1024;
        }
        n %= 1024;

        String ans = String.format("%.1f", n);
        if (i == 0) System.out.println(n+" B");
        else if (i == 1) System.out.println(ans+" KB");
        else if (i == 2) System.out.println(ans+" MB");
        else if (i == 3) System.out.println(ans+" GB");
        else if (i == 4) System.out.println(ans+" TB");
    }
}
