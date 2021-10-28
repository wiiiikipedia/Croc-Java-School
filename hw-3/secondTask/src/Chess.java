public class Chess {
    private int x;
    private int y;

    public static final int BOARD = 8;

    private static final String xIndexMapping = "abcdefgh";

    public Chess(int x, int y) {
        setX(x);
        setY(y);
    }

    public Chess(String position) {
        setPosition(position);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        if (!isIndexValid(x)) {
            throw new IllegalArgumentException(xInvalid(x));
        }
        this.x = x;
    }

    public void setY(int y) {
        if (!isIndexValid(y)) {
            throw new IllegalArgumentException(yInvalid(y));
        }
        this.y = y;
    }

    public void setPosition(String position) {
        if (position.length() != 2) {
            throw new IllegalArgumentException("Некорректный ввод: '" + position + "'. Введите два аргумента.");
        }

        char xChar = position.charAt(0);
        int x = xIndexMapping.indexOf(xChar);
        if (x != -1) {
            this.x = x;
        } else {
            throw new IllegalArgumentException("Некорректный ввод: '" + position + "'. Первый аргумент должен быть символом от 'a' до 'h'.");
        }


        char yChar = position.charAt(1);
        int y = Character.getNumericValue(yChar) - 1;
        if (Character.isDigit(yChar) && y < BOARD) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("Некорректный ввод: '" + position + "'. Второй аргумент должен быть цифрой от 0 до " + (BOARD - 1) + ".");
        }
    }

    private boolean isIndexValid(int n) {
        return n >= 0 && n < BOARD;
    }

    private String xInvalid(int n) {
        return "Значение х = " + n + " некорректно. Значение должно быть цифрой от 0 до " + (BOARD - 1);
    }

    private String yInvalid(int n) {
        return "Значение у = " + n + " некорректно. Значение должно быть цифрой от 0 до " + (BOARD - 1);
    }

    @Override
    public String toString() {
        return Character.toString(xIndexMapping.charAt(x)) + (y + 1);
    }
}
