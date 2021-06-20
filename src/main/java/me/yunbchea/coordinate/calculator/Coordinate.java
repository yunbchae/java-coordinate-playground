package me.yunbchea.coordinate.calculator;

import java.util.Objects;

public class Coordinate {

    private static final IllegalArgumentException INVALID_COORDINATE_VALUE_EXCEPTION = new IllegalArgumentException("유효하지 않은 좌표 값 입니다.");
    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 24;

    private final int value;

    private Coordinate(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MINIMUM_VALUE || value > MAXIMUM_VALUE) {
            throw INVALID_COORDINATE_VALUE_EXCEPTION;
        }
    }

    public static Coordinate of(int value) {
        return new Coordinate(value);
    }

    public int diff(Coordinate that) {
        return Math.abs(this.value - Objects.requireNonNull(that).value);
    }
}
