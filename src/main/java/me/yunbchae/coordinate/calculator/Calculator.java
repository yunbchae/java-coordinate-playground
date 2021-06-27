package me.yunbchae.coordinate.calculator;

import me.yunbchae.coordinate.calculator.exception.PointsInputException;
import me.yunbchae.coordinate.calculator.model.CalculateResult;
import me.yunbchae.coordinate.calculator.model.DistanceMeasurable;
import me.yunbchae.coordinate.calculator.model.Line;
import me.yunbchae.coordinate.calculator.model.Points;
import me.yunbchae.coordinate.calculator.view.*;

import java.util.Scanner;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;
    private final Renderer pointsRenderer;
    private final Renderer resultRenderer;

    public Calculator(InputView inputView, OutputView outputView, Renderer pointsRenderer, Renderer resultRenderer) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pointsRenderer = pointsRenderer;
        this.resultRenderer = resultRenderer;
    }

    public Points input() {
        Points points = null;
        while(points == null) {
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
            return null;
        }
    }

    private void printPoints(Points points) {
        outputView.print(points, pointsRenderer);
    }

    private void printResult(CalculateResult result) {
        outputView.print(result, resultRenderer);
    }

    private CalculateResult calculate(Points points) {
        if (points instanceof Line) {
            return CalculateResult.of((DistanceMeasurable) points);
        }
        throw PointsInputException.invalidFormat();
    }

    public static void main(String[] args) {
        try {
            Calculator calculator = createCalculator();
            Points points = calculator.input();
            calculator.printPoints(points);
            CalculateResult result = calculator.calculate(points);
            calculator.printResult(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Calculator createCalculator() {
        InputView inputView = new ScannerInputView(new Scanner(System.in));
        OutputView outputView = new PrintStreamOutputView(System.out);
        Renderer pointsRenderer = new PointsRenderer();
        Renderer resultRenderer = new CalculateResultRenderer();
        return new Calculator(inputView, outputView, pointsRenderer, resultRenderer);
    }
}
