package me.yunbchae.coordinate.calculator.exception;

public class CaculateFailException extends RuntimeException {

    public static final CaculateFailException INVALID_CACULATE_RESULT_EXCEPTION = new CaculateFailException("계산 결과 오류입니다.");

    public CaculateFailException(String message) {
        super(message);
    }

    public static CaculateFailException invalidCaculateResult() {
        return INVALID_CACULATE_RESULT_EXCEPTION;
    }
}
