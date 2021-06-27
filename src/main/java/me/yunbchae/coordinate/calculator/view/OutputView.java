package me.yunbchae.coordinate.calculator.view;

import me.yunbchae.coordinate.calculator.Points;

public interface OutputView {
    void printInputMessage();
    void printInputErrorMessage(PointsInputException pointsInputException);
    void printPoints(Points points, PointsRenderer pointsRenderer);
}
