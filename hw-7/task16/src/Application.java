import java.util.*;

public class Application {
    public static ArrayList<String[]> set18 = new ArrayList<String[]>(); //список людей 0-18
    public static ArrayList<String[]> set25 = new ArrayList<String[]>(); // список людей 19-25
    public static ArrayList<String[]> set35 = new ArrayList<String[]>(); // список людей 26-35
    public static ArrayList<String[]> set45 = new ArrayList<String[]>(); // список людей 36-45
    public static ArrayList<String[]> set60 = new ArrayList<String[]>(); // список людей 46-60
    public static ArrayList<String[]> set80 = new ArrayList<String[]>(); // список людей 61-80
    public static ArrayList<String[]> set100 = new ArrayList<String[]>(); // список людей 81-100
    public static ArrayList<String[]> set123 = new ArrayList<String[]>(); // список людей 101-123

    public static void main(String[] args) {

        //нужна сортировка по второму столбцу каждого списка и вывод
        Scanner in = new Scanner(System.in);

        boolean flag = true;
        while(flag) {
            int i = 0;
            String s = in.nextLine();
            if (s.equals("END")) {
                flag = false;
            }
            else {
                String[] info = s.split(",");
                //ENDString newStr = info[0]+" ("+info[1]+")";
                int age = Integer.parseInt(info[1]);
                if (age >= 0 && age <= 18) {
                    set18.add(new String[]{info[0], info[1]});
                }
                if (age >= 19 && age <= 25) {
                    set25.add(new String[]{info[0], info[1]});
                    ;
                }
                if (age >= 26 && age <= 35) {
                    set35.add(new String[]{info[0], info[1]});
                    ;
                }
                if (age >= 36 && age <= 45) {
                    set45.add(new String[]{info[0], info[1]});
                    ;
                }
                if (age >= 46 && age <= 60) {
                    set60.add(new String[]{info[0], info[1]});
                    ;
                }
                if (age >= 61 && age <= 80) {
                    set80.add(new String[]{info[0], info[1]});
                    ;
                }
                if (age >= 81 && age <= 100) {
                    set100.add(new String[]{info[0], info[1]});
                    ;
                }
                if (age >= 101 && age <= 123) {
                    set123.add(new String[]{info[0], info[1]});
                    ;
                }
            }
        }

        sortSet(set18);
        sortSet(set25);
        sortSet(set35);
        sortSet(set45);
        sortSet(set60);
        sortSet(set80);
        sortSet(set100);
        sortSet(set123);


        output(set123, "100+");
        output(set100, "81-100");
        output(set80, "61-80");
        output(set60, "46-60");
        output(set45, "36-45");
        output(set35, "26-35");
        output(set25, "19-25");
        output(set18, "0-18");


    }

    public static ArrayList<String[]> sortSet(ArrayList<String[]> arr) {
        boolean f = true;
        while(f) {
            f = false;
            for (int i = 1; i < arr.size(); ++i) {
                String s = arr.get(i)[1];
                if (Integer.parseInt(arr.get(i)[1]) > Integer.parseInt(arr.get(i - 1)[1])) {
                    f = true;

                    swap(arr, i);
                }
                else if (Integer.parseInt(arr.get(i)[1]) == Integer.parseInt(arr.get(i - 1)[1])) {
                    int v = arr.get(i)[0].compareTo(arr.get(i-1)[0]);
                    if (v<0) {
                        swap(arr, i);
                    }
                }
            }
        }
        return  arr;
    }

    private static void swap(ArrayList<String[]> arr, int i) {
        String temp = arr.get(i)[1];
        String temp_name = arr.get(i)[0];

        arr.get(i)[1] = arr.get(i-1)[1];
        arr.get(i-1)[1] = temp;

        arr.get(i)[0] = arr.get(i-1)[0];
        arr.get(i-1)[0] = temp_name;
    }

    public static void output(ArrayList<String[]> set, String s) {
        //вывод для каждой группы
        String str = s+": ";
        for (int i = 0; i < set.size(); ++i) {
            str += set.get(i)[0]+" ("+set.get(i)[1]+"), ";
        }
        //str += set.get(set.size()-1)[0]+" ("+set.get(set.size()-1)[1]+")";
        str = str.substring(0,str.length()-2);

        System.out.println(str);
    }
}

