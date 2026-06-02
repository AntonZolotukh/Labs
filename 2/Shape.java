public abstract class Shape {
protected String color;
    protected boolean is3D;
    private static int shapeCount = 0;

    public Shape() {
        this.color = "белый";
        this.is3D = false;
        shapeCount++;
    }

    public Shape(String color, boolean is3D) {
        this.color = color;
        this.is3D = is3D;
        shapeCount++;
    }

    public abstract double getVolume();
    public abstract double getSurfaceArea();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public static int getShapeCount() {
        return shapeCount;
    }

    public void displayInfo() {
        System.out.println("Shape: " + this.getClass().getSimpleName());
        System.out.println("Color: " + color);
        System.out.println("3D: " + is3D);
        System.out.println("Volume: " + getVolume());
        System.out.println("Surface Area: " + getSurfaceArea());
        System.out.println("------------------------");
    }
}
