package me.yunbchae.coordinate.calculator.view;

import me.yunbchae.coordinate.calculator.exception.RenderFailException;
import me.yunbchae.coordinate.calculator.model.CalculateResult;

public class CalculateResultRenderer implements Renderer {

    public static final String DISTANCE_PRINT_FORMAT = "두 점 사이의 거리는 %f";

    @Override
    public String render(Renderable renderable) {
        if (!(renderable instanceof CalculateResult)) {
            throw RenderFailException.invalidType();
        }
        return printResult((CalculateResult) renderable);
    }

    private String printResult(CalculateResult renderable) {
        return String.format(DISTANCE_PRINT_FORMAT, renderable.getResult());
    }
}
