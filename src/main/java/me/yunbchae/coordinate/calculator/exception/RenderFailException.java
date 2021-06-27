package me.yunbchae.coordinate.calculator.exception;

public class RenderFailException extends RuntimeException {

    public static final RenderFailException RENDER_FAIL_EXCEPTION = new RenderFailException("렌더링 타입이 유효하지 않습니다.");

    public RenderFailException(String message) {
        super(message);
    }

    public static RenderFailException invalidType() {
        return RENDER_FAIL_EXCEPTION;
    }
}
