class Circle implements  Figure{

    int x, y, r;
    String title;

    public Circle(int x, int y, int r, String title) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.title = title;
    }

    @Override
    public String typeFigure() {
        String type = "C";
        return type;
    }

    @Override
    public String label() {
        return title;
    }

    @Override
    public int[] coordinate() {
        int[] center = {x,y,r};
        return center;
    }
}
