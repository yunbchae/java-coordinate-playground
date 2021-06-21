package me.yunbchea.coordinate.calculator.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public CalculateRequest getRequest() {
        try {
            return CalculateRequest.of(scanner.nextLine());
        } catch (Exception e) {
            return null;
        }
    }

}
