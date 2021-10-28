public class Application {
    public static void main(String[] args) {
        String[] strPositions_1 = new String[]{"g8", "e7", "e6"};
        String[] strPositions_2 = new String[]{"g8", "e7", "c8"};

        checkFig(strPositions_1);
        checkFig(strPositions_2);

        Chess firstFig = new Chess(1, 1);
        System.out.println(firstFig);

        Chess p2 = new Chess("b3");
        System.out.println(p2);

        System.out.println();
    }

    private static void checkFig(String[] strPositions) {
        String s = "[in]  ";
        for (int i = 0; i < strPositions.length; ++i) {
            s += strPositions[i]+' ';
        }

        System.out.println(s);

        Chess[] positions = new Chess[strPositions.length];
        for (int i = 0; i < strPositions.length; i++) {
            positions[i] = new Chess(strPositions[i]);
        }

        System.out.print("[out] ");

        try {
            ChessKnight.move(positions);
            System.out.println("OK");
        } catch (IllegalMoveException e) {
            System.out.println(e);
        }
    }
}
