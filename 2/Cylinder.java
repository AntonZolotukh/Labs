public class Cylinder extends Shape {
    private double radius;
    private double height;

    public Cylinder() {
        super();
        this.radius = 1.0;
        this.height = 1.0;
    }

    public Cylinder(String color, double radius, double height) {
        super(color, true);
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}
