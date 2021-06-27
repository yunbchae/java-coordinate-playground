package me.yunbchae.coordinate.calculator;

import me.yunbchae.coordinate.calculator.view.*;

import java.util.Scanner;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;
    private final PointsRenderer pointsRenderer;

    public Calculator(InputView inputView, OutputView outputView, PointsRenderer pointsRenderer) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pointsRenderer = pointsRenderer;
    }

    public Points input() {
        Points points = null;
        while(points == null) {
            outputView.printInputMessage();
            points = inputPoints();
        }
        outputView.printPoints(points, pointsRenderer);
        return points;
    }

    private Points inputPoints() {
        try {
            return inputView.inputPoints();
        } catch (PointsInputException e) {
            outputView.printInputErrorMessage(e);
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            Calculator calculator = createCalculator();
            Points points = calculator.input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Calculator createCalculator() {
        InputView inputView = new ScannerInputView(new Scanner(System.in));
        OutputView outputView = new PrintStreamOutputView(System.out);
        PointsRenderer pointsRenderer = new PointsRenderer();
        return new Calculator(inputView, outputView, pointsRenderer);
    }
}
