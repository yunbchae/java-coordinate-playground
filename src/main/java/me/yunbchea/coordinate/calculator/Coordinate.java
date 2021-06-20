package me.yunbchea.coordinate.calculator;

public class Coordinate {

    private static final IllegalArgumentException CREATE_FAIL_EXCEPTION = new IllegalArgumentException("유효하지 않은 좌표 값 입니다.");
    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 24;

    private final int value;

    public Coordinate(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value < MINIMUM_VALUE || value > MAXIMUM_VALUE) {
            throw CREATE_FAIL_EXCEPTION;
        }
    }
}
