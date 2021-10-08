import java.util.Scanner;

public class Application {
    static public void main (String []args) {
        System.out.print("Введите размер массива: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int [] arr = new int[n];
        System.out.print("Введите элементы массива: ");
        for (int i = 0; i < arr.length; ++i) arr[i] = in.nextInt();
        in.close();

        int max = -1000000000;
        int indexMax = -1;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > max) {
                indexMax = i;
                max = arr[i];
            }
        }

        int min = 1000000000;
        int indexMin = -1;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < min) {
                indexMin = i;
                min = arr[i];
            }
        }

        int temp = arr[0];
        arr[0] = min;
        arr[indexMin] = temp;

        temp = arr[n-1];
        arr[n-1] = max;
        arr[indexMax] = temp;

        System.out.print("Результат: ");
        for(int i = 0; i < n; ++i)
            System.out.print(arr[i]+" ");
    }
}
