package org.example;

public  abstract class BaseFigure {
    public abstract BaseFigure copy();
}

class CircleFigure extends BaseFigure {
    private double radius;

    public CircleFigure (double radius) {
        this.radius = radius;
    }

    @Override   // Covariant in Return type
    public CircleFigure copy() {
        return new CircleFigure(this.radius);
    }

    public double getRadius() {
        return radius;
    }

    public static void main(String[] args) {
        final BaseFigure baseFigure = new CircleFigure(13);
        final CircleFigure circleFigure = new CircleFigure(7);

        // #1 covariant return type
        final CircleFigure circleTypeCopy = circleFigure.copy();
        final double radius = circleTypeCopy.getRadius();
        System.out.println("radius of copy: " + radius);

        // #2 compile error  - upcast
        // final CircleFigure circleTypeCopy1 = baseFigure.copy();

        // #3 Compile Type Base / Runtime Type: circlefigure
        final BaseFigure baseCopy = baseFigure.copy();

        if (baseCopy instanceof CircleFigure) {
            final CircleFigure circleBaseCopy = (CircleFigure) baseCopy;
            System.out.println("baseCopy compile type Basefigure");
            System.out.println("baseCopy runtime type CircleFigure");
            System.out.println("radius of copy: " + circleBaseCopy.getRadius());
        }
    }
}
