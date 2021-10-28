public class IllegalMoveException extends Exception {
    public final Chess start;
    public final Chess end;

    public IllegalMoveException(Chess start, Chess end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Конь не может так ходить: " + start + " -> " + end;
    }
}