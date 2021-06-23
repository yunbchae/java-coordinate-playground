package me.yunbchae.coordinate.calculator.view;

import java.io.PrintStream;

public class PrintStreamOutputView implements OutputView {

    public static final String INPUT_MESSAGE = "좌표를 입력하세요.";

    private final PrintStream printStream;

    public PrintStreamOutputView(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void printInputMessage() {
        printStream.println(INPUT_MESSAGE);
    }

    @Override
    public void printInputErrorMessage(PointsInputException inputException) {
        printStream.println(inputException.getMessage());
    }
}
