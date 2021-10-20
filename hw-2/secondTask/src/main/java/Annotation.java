public class Annotation {
    Figure figure;
    public Annotation (Figure figure) {
        this.figure = figure;
    }

    Annotation annotation = new Annotation(figure);

    void print () {
        String s = "";
        if (figure.typeFigure() == "C") {
            s = figure.typeFigure()
                    + " ("+figure.coordinate()[0]
                    + ","+figure.coordinate()[1]+") "
                    +figure.coordinate()[2]
                    +": "+figure.label();
        }
        else if (figure.typeFigure() == "R") {
            s = figure.typeFigure()
                    + " ("+figure.coordinate()[0]
                    + ","+figure.coordinate()[1]+") "
                    + "("+figure.coordinate()[2]
                    + ","+figure.coordinate()[3]+")"
                    +": "+figure.label();
        }
        else {
            s = "Неопределенный вид фигуры!";
        }

        System.out.println(s);
    }

    Annotation findByLabel(String l) {
        if (figure.label().contains(l))
            return annotation;
        else return null;
    }

    Annotation findByPoint(int x, int y) {
        if (figure.typeFigure() == "R") {
            if(figure.coordinate()[0]<x && figure.coordinate()[2]>x && figure.coordinate()[1]>y && figure.coordinate()[3]<y)
                return annotation;
            else return null;
        }
        else {
            if(Math.pow((figure.coordinate()[0]-x),2) +Math.pow((figure.coordinate()[1]-y),2) <= Math.pow(figure.coordinate()[2],2))
                return annotation;
            else return null;
        }
    }
}
