public class Annotation {
    Figure figure;
    public Annotation (Figure figure) {
        this.figure = figure;
    }

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

        System.out.println(s);
    }
}
