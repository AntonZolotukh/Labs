public class Sphere extends Shape {
    private double radius;

    public Sphere() {
        super();
        this.radius = 1.0;
    }

    public Sphere(String color, double radius) {
        super(color, true);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}
