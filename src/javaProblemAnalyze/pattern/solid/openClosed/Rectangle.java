package javaProblemAnalyze.pattern.solid.openClosed;

public class Rectangle extends Shape {

    public double width = 0;
    public double height = 0;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double Area() {
        return width * height;
    }
}
