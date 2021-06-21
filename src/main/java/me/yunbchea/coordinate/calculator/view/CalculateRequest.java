package me.yunbchea.coordinate.calculator.view;

import me.yunbchea.coordinate.calculator.Point;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateRequest {

    private static final IllegalArgumentException INVALID_INPUT_EXCEPTION = new IllegalArgumentException("유효하지 않은 입력입니다.");
    private static final String POINT_INPUT_FORMAT = "\\(\\d+,\\d+\\)";
    private static final String POINT_INPUT_DELIMITER = "-";
    private static final String COORDINATE_INPUT_DELIMITER = ",";
    private static final int X_COORDINATE_INDEX = 0;
    private static final int Y_COORDINATE_INDEX = 1;
    private static final int LINE_POINT_COUNT = 2;

    private final List<Point> points;

    private CalculateRequest(List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static CalculateRequest of(String input) {
        String[] pointStrings = input.split(POINT_INPUT_DELIMITER);
        if (!validatePointCount(pointStrings) || !validatePointInputFormat(pointStrings)) {
            throw INVALID_INPUT_EXCEPTION;
        }
        return new CalculateRequest(parse(pointStrings));
    }

    private static List<Point> parse(String[] pointStrings) {
        return Arrays.stream(pointStrings)
                .map(CalculateRequest::convertToPosition)
                .collect(Collectors.toList());
    }

    private static Point convertToPosition(String pointString) {
        String[] coordinatesStrings = pointString.substring(1, pointString.length() - 1).split(COORDINATE_INPUT_DELIMITER);
        int[] coordinates = Arrays.stream(coordinatesStrings).mapToInt(Integer::parseInt).toArray();
        return Point.of(coordinates[X_COORDINATE_INDEX], coordinates[Y_COORDINATE_INDEX]);
    }

    private static boolean validatePointCount(String[] pointStrings) {
        return pointStrings.length == LINE_POINT_COUNT;
    }

    private static boolean validatePointInputFormat(String[] pointStrings) {
        return Arrays.stream(pointStrings).allMatch(pointString -> pointString.matches(POINT_INPUT_FORMAT));
    }


}
