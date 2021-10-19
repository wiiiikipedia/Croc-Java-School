import java.util.Scanner;

public class Application {
    static public void main (String []args) {

        int [] a = fillArray();

        int maxInd = findMax(a);
        a = swap(a, maxInd, a.length-1);

        int minInd = findMin(a);
        a = swap(a, minInd, 0);

        printResult(a);
   }

    static int[] fillArray() {
        System.out.print("Введите размер массива: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int [] arr = new int[n];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < arr.length; ++i) arr[i] = in.nextInt();
        in.close();
        return arr;
    }

    static int findMin (int[] arr) {
        int min = Integer.MAX_VALUE;
        int indexMin = -1;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < min) {
                indexMin = i;
                min = arr[i];
            }
        }

        return indexMin;
    }

    static int findMax(int[] arr) {
        int max = -Integer.MAX_VALUE;
        int indexMax = -1;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > max) {
                indexMax = i;
                max = arr[i];
            }
        }
        return indexMax;
    }

    static void printResult (int[] arr) {
        System.out.print("Результат: ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }

    static int[] swap (int[] arr, int indexFrom, int indexTo) {
        int temp = arr[indexTo];
        arr[indexTo] = arr[indexFrom];
        arr[indexFrom] = temp;

        return arr;
    }

}
