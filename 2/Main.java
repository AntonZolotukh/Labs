public class Main {
public static void main(String[] args) {
        Shape sphere = new Sphere("красный", 3.0);
        Shape prism = new RectangularPrism("синий", 2.0, 3.0, 4.0);
        Shape cylinder = new Cylinder("зеленый", 1.5, 5.0);

        sphere.displayInfo();
        prism.displayInfo();
        cylinder.displayInfo();

        System.out.println("Всего создано фигур: " + Shape.getShapeCount());
    }
}
