package me.yunbchea.coordinate.calculator;

import me.yunbchea.coordinate.calculator.view.CalculateRequest;
import me.yunbchea.coordinate.calculator.view.InputView;
import me.yunbchea.coordinate.calculator.view.OutputView;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;

    public Calculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public CalculateRequest getRequest() {
        CalculateRequest request = null;
        while(request == null) {
            outputView.print("좌표를 입력하세요.");
            request = inputView.getRequest();
            outputView.print(request);
        }
        return request;
    }

    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            Calculator calculator = new Calculator(inputView, outputView);
            CalculateRequest request = calculator.getRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
