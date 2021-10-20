class Rectangle implements Figure{

    int x1, y1, x2, y2;
    String title;

    public Rectangle(int x1, int y1, int x2, int y2, String title) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.title = title;
    }


    @Override
    public String typeFigure() {
        return "R";
    }

    @Override
    public String label() {
        return title;
    }

    @Override
    public int[] coordinate() {
        int [] coor = {x1, y1, x2, y2};
        return coor;
    }
}
