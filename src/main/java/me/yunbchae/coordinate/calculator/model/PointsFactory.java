package me.yunbchae.coordinate.calculator.model;

import me.yunbchae.coordinate.calculator.exception.PointsInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PointsFactory {

    private static final String POINT_INPUT_DELIMITER = "-";

    public static Points create(String inputPoints) {
        List<Point> points = parse(inputPoints);
        if (points.size() == Line.POINT_COUNT) {
            return Line.of(points);
        }
        throw PointsInputException.invalidFormat();
    }

    private static List<Point> parse(String inputString) {
        return Arrays.stream(inputString.split(POINT_INPUT_DELIMITER))
                .map(Point::of)
                .collect(Collectors.toList());
    }
}
