package me.yunbchea.coordinate.calculator;

import java.util.Objects;

public class Point {

    private final Coordinate x;
    private final Coordinate y;

    private Point(Coordinate x, Coordinate y) {
        this.x = Objects.requireNonNull(x);
        this.y = Objects.requireNonNull(y);
    }

    public static Point of(int x, int y) {
        return new Point(Coordinate.of(x), Coordinate.of(y));
    }

    public double calculateDistanceFrom(Point that) {
        return Objects.requireNonNull(that).calculateDistanceFrom(x, y);
    }

    private double calculateDistanceFrom(Coordinate x, Coordinate y) {
        int diffX = this.x.diff(x);
        int diffY = this.y.diff(y);
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    }
}
