package me.yunbchae.coordinate.calculator.model;

import me.yunbchae.coordinate.calculator.exception.PointsInputException;

import java.util.List;

public class Line extends Points implements DistanceMeasurable {

    public static final int POINT_COUNT = 2;

    private Line(List<Point> points) {
        super(points);
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    @Override
    protected void validate(List<Point> points) {
        if (points.size() != POINT_COUNT) {
            throw PointsInputException.invalidFormat();
        }
    }

    @Override
    public double measure() {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        return p1.measureDistanceFrom(p2);
    }
}
