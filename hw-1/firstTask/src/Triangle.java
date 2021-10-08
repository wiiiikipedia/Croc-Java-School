class Triangle {
    double[] x;//x[i] хранит х-координату i+1 вершины
    double [] y; //у[i] хранит у-координату i+1 вершины
    double s; //площать треугольника


    Triangle (double []a, double []b) { //конструктор класса
        x = new double[3];
        this.x = a;
        y = new double[3];
        this.y = b;
    }

    double sideLength(int i, int j) { //метод для нахождения длины стороны, вводятся номера вершин стороны
        --i; --j;
        double len = Math.sqrt(Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2));
        return  len;
    }

    double perimetr () { //метод для нахождения полупериметра
        double p = (sideLength(1,2) + sideLength(2,3) + sideLength(1,3))/2;
        return  p;
    }

    void Square() { //метод для нахождения площади треугольника
        s = Math.sqrt(perimetr()*(perimetr()-sideLength(1,2))*(perimetr()-sideLength(2,3))*(perimetr()-sideLength(1,3)));
        System.out.println(Math.round(s));
    }
}
