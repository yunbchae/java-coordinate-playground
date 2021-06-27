package me.yunbchae.coordinate.calculator.view;

import me.yunbchae.coordinate.calculator.exception.PointsInputException;

public interface OutputView {
    void printInputMessage();
    void printInputErrorMessage(PointsInputException pointsInputException);
    void print(Renderable renderable, Renderer renderer);
}
