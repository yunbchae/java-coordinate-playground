package me.yunbchae.coordinate.calculator.view;

import me.yunbchae.coordinate.calculator.Coordinate;
import me.yunbchae.coordinate.calculator.Point;
import me.yunbchae.coordinate.calculator.Points;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PointsRenderer {

    private static final String[][] DEFAULT_COORDINATE_SYSTEM;
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String DELIMITER = "";
    private static final int COORDINATE_SYSTEM_LENGTH = 27;
    private static final int Y_OFFSET = COORDINATE_SYSTEM_LENGTH - 3;
    private static final int X_OFFSET = 2;
    private static final String DOT = " *";

    static {
        DEFAULT_COORDINATE_SYSTEM = new String[][] {
                {"24"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"22"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"20"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"18"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"16"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"14"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"12"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"10"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {" 8"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {" 6"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {" 4"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {" 2"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {" 0"," |","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  ","  "},
                {"  "," +","--","--","--","--","--","--","--","--","--","--","--","--","--","--","--","--","--","--","--","--","--","--","--","--","--"},
                {"  ","  "," 0","  "," 2","  "," 4","  "," 6","  "," 8","  ","10","  ","12","  ","14","  ","16","  ","18","  ","20","  ","22","  ","24"},
        };
    }

    public String render(Points points) {
        return convertToString(createCoordinateSystemWith(points));
    }

    private String[][] createCoordinateSystemWith(Points points) {
        String[][] coordinateSystem = createEmptyCoordinateSystem();
        List<Point> pointList = points.getPoints();
        for (Point point : pointList) {
            dot(coordinateSystem, point.getX(), point.getY());
        }

        return coordinateSystem;
    }

    private String[][] createEmptyCoordinateSystem() {
        String[][] coordinateSystem = new String[COORDINATE_SYSTEM_LENGTH][COORDINATE_SYSTEM_LENGTH];
        for (int i = 0; i< COORDINATE_SYSTEM_LENGTH; ++i) {
            coordinateSystem[i] = DEFAULT_COORDINATE_SYSTEM.clone()[i];
        }
        return coordinateSystem;
    }

    private void dot(String[][] coordinateSystem, Coordinate x, Coordinate y) {
        coordinateSystem[Y_OFFSET - y.getValue()][X_OFFSET + x.getValue()] = DOT;
    }

    private String convertToString(String[][] coordinateSystem) {
        return Arrays.stream(coordinateSystem)
                .map(row -> String.join(DELIMITER, row))
                .collect(Collectors.joining(NEW_LINE));
    }
}
