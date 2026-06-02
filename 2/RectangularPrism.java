public class RectangularPrism extends Shape {
    private double length;
    private double width;
    private double height;

    public RectangularPrism() {
        super();
        this.length = 1.0;
        this.width = 1.0;
        this.height = 1.0;
    }

    public RectangularPrism(String color, double length, double width, double height) {
        super(color, true);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getVolume() {
        return length * width * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }
}
