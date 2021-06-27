package me.yunbchae.coordinate.calculator;

import me.yunbchae.coordinate.calculator.view.PointsInputException;

import java.util.Arrays;
import java.util.Objects;

public class Point {

    private static final String POINT_INPUT_FORMAT = "\\(\\d+,\\d+\\)";
    private static final String POINTS_SPLIT_REGEX = "[(,)]";
    private static final String INTEGER_REGEX = "[\\d]+";
    private static final int X_COORDINATE_INDEX = 0;
    private static final int Y_COORDINATE_INDEX = 1;

    private final Coordinate x;
    private final Coordinate y;

    private Point(Coordinate x, Coordinate y) {
        this.x = Objects.requireNonNull(x);
        this.y = Objects.requireNonNull(y);
    }

    public static Point of(String pointString) {
        validatePointFormat(pointString);
        int[] coordinates = parse(pointString);
        return new Point(Coordinate.of(coordinates[X_COORDINATE_INDEX]), Coordinate.of(coordinates[Y_COORDINATE_INDEX]));
    }

    private static void validatePointFormat(String pointString) {
        if (!pointString.matches(POINT_INPUT_FORMAT)) {
            throw PointsInputException.invalidFormat();
        }
    }

    private static int[] parse(String pointString) {
        return Arrays.stream(pointString.split(POINTS_SPLIT_REGEX))
                .filter(coordinatesString -> coordinatesString.matches(INTEGER_REGEX))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public double calculateDistanceFrom(Point that) {
        return Objects.requireNonNull(that).calculateDistanceFrom(x, y);
    }

    private double calculateDistanceFrom(Coordinate x, Coordinate y) {
        int diffX = this.x.diff(x);
        int diffY = this.y.diff(y);
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    }

    public Coordinate getX() {
        return x;
    }

    public Coordinate getY() {
        return y;
    }
}
