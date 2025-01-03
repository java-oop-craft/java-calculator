package calculator.controller;

import calculator.view.InputView;

public class CalculatorController {

    public void run() {
        InputView inputView = new InputView();
        inputView.readNumberWithDelimiter();
    }
}
