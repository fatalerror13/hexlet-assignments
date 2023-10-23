package exercise;

// BEGIN

// END
public class Circle {

    Point center;
    int radius;

    public Circle(final Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Error");
        }

        return Math.PI * radius * radius;
    }
}