package javaProblemAnalyze.pattern.solid.openClosed;

public class Circle extends Shape {


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double radius ;


    @Override
    public double Area() {
        return radius*radius*Math.PI;
    }
}
