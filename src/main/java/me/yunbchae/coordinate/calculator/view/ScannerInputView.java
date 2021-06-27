package me.yunbchae.coordinate.calculator.view;

import me.yunbchae.coordinate.calculator.Points;
import me.yunbchae.coordinate.calculator.PointsFactory;

import java.util.Scanner;

public class ScannerInputView implements InputView {

    private final Scanner scanner;

    public ScannerInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Points inputPoints() {
        return PointsFactory.create(scanner.nextLine());
    }
}
