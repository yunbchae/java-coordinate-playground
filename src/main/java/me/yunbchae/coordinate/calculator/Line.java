package me.yunbchae.coordinate.calculator;

import me.yunbchae.coordinate.calculator.view.PointsInputException;

import java.util.List;

public class Line extends Points {

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
}
