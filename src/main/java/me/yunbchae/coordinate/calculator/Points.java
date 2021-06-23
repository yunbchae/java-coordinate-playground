package me.yunbchae.coordinate.calculator;

import me.yunbchae.coordinate.calculator.view.PointsInputException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Points {

    private static final Points EMPTY_POINTS = new Points(Collections.emptyList());
    private static final String POINT_INPUT_DELIMITER = "-";
    private static final int LINE_POINT_COUNT = 2;

    private final List<Point> points;

    private Points(List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static Points of(String input) {
        String[] pointStrings = input.split(POINT_INPUT_DELIMITER);
        validate(pointStrings);
        return new Points(parse(pointStrings));
    }

    private static void validate(String[] pointStrings) {
        if (pointStrings.length != LINE_POINT_COUNT) {
            throw PointsInputException.invalidFormat();
        }
    }

    private static List<Point> parse(String[] pointStrings) {
        return Arrays.stream(pointStrings)
                .map(Point::of)
                .collect(Collectors.toList());
    }

    public static Points empty() {
        return EMPTY_POINTS;
    }

    public boolean isEmpty() {
        return this.equals(EMPTY_POINTS);
    }
}
