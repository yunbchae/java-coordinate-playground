package me.yunbchae.coordinate.calculator.view;

public class PointsInputException extends RuntimeException {

    private static final PointsInputException INVALID_INPUT_EXCEPTION = new PointsInputException("유효하지 않은 입력입니다.");

    private PointsInputException(String message) {
        super(message);
    }

    public static PointsInputException invalidFormat() {
        return INVALID_INPUT_EXCEPTION;
    }
}
