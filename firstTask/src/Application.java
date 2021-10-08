import java.util.Scanner;

public class Application {

    public static void main (String [] args) {
        double [] a = new double[3];
        double [] b = new double[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; ++i) {
            int n = i+1;
            System.out.println("Введите координаты "+ n + " вершины:");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            a[i] = x;
            b[i] = y;
        }
        scanner.close();

        Triangle triangle = new Triangle(a, b);
        System.out.println();
        System.out.println("Площадь треугольника:");
        triangle.Square();
    }
}
