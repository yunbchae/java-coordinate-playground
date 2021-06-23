package me.yunbchae.coordinate.calculator;

import me.yunbchae.coordinate.calculator.view.*;

import java.util.Scanner;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;

    public Calculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Points input() {
        Points points = Points.empty();
        while(points.isEmpty()) {
            outputView.printInputMessage();
            points = inputPoints();
        }
        return points;
    }

    private Points inputPoints() {
        try {
            return inputView.inputPoints();
        } catch (PointsInputException e) {
            outputView.printInputErrorMessage(e);
            return Points.empty();
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
        return new Calculator(inputView, outputView);
    }
}
