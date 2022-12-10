package subway.controller;

import subway.view.InputVIew;
import subway.view.OutputView;

public class SubwayPathController {
    private final OutputView outputView = new OutputView();
    private final InputVIew inputVIew = new InputVIew();

    public void run() {
        outputView.printMainMenu();
        inputVIew.inputFeature();
    }
}
