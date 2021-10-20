public class MoveRectangle implements Movable {

    Figure figure;
    public MoveRectangle(Figure figure) {
        this.figure = figure;
    }

    @Override
    public Figure move(int x, int y) {
        figure.coordinate()[0] += x;
        figure.coordinate()[2] += x;
        figure.coordinate()[1] += y;
        figure.coordinate()[3] += y;
        return  figure;
    }
}
