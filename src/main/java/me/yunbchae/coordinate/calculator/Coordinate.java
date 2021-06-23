package me.yunbchae.coordinate.calculator;

import me.yunbchae.coordinate.calculator.view.PointsInputException;

import java.util.Objects;

public class Coordinate {

    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 24;

    private final int value;

    private Coordinate(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MINIMUM_VALUE || value > MAXIMUM_VALUE) {
            throw PointsInputException.invalidFormat();
        }
    }

    public static Coordinate of(int value) {
        return new Coordinate(value);
    }

    public int diff(Coordinate that) {
        return Math.abs(this.value - Objects.requireNonNull(that).value);
    }
}
