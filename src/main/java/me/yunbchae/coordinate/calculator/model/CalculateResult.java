package me.yunbchae.coordinate.calculator.model;

import me.yunbchae.coordinate.calculator.exception.CaculateFailException;
import me.yunbchae.coordinate.calculator.view.Renderable;

public class CalculateResult implements Renderable {

    private final double result;

    public CalculateResult(double result) {
        validate(result);
        this.result = result;
    }

    private void validate(double result) {
        if (result < 0) {
            throw CaculateFailException.invalidCaculateResult();
        }
    }

    public static CalculateResult of(DistanceMeasurable distanceMeasurable) {
        return new CalculateResult(distanceMeasurable.measure());
    }

    public double getResult() {
        return result;
    }
}
