package me.yunbchea.coordinate.calculator.view;

public class OutputView {
    public void print(String message) {
        System.out.println(message);
    }

    public void print(CalculateRequest request) {
        if (request == null) {
            print("좌표 값이 올바르지 않습니다.");
        }
    }
}
