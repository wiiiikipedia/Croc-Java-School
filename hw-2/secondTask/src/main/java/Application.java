public class Application {
    public static void main (String []args) {
        Figure rectangle = new Rectangle(0, 0, 4, 5, "Car");
        Figure circle = new Circle(4, 4, 10, "Sun");

        Annotation annotation = new Annotation(rectangle);
        annotation.print();
        annotation = new Annotation(circle);
        annotation.print();
    }
}

