public class ChessKnight {
    public static boolean isMoveCorrect(Chess start, Chess end) {
        return Math.abs(end.getX() - start.getX()) == 1 && Math.abs(end.getY() - start.getY()) == 2
                || Math.abs(end.getX() - start.getX()) == 2 && Math.abs(end.getY() - start.getY()) == 1;
    }

    public static void move (Chess[] positions) throws IllegalMoveException {
        for (int i = 0; i < positions.length - 1; i++) {
            Chess start = positions[i];
            Chess end = positions[i + 1];
            if (!isMoveCorrect(start, end)) {
                throw new IllegalMoveException(start, end);
            }
        }
    }
}
