public class MoveCircle implements  Movable{

    Figure figure;
    public MoveCircle(Figure figure) {
        this.figure = figure;
    }

    @Override
    public Figure move(int x, int y) {
        figure.coordinate()[0] += x;
        figure.coordinate()[1] += y;
        return  figure;
    }
}
