package subway.controller;

import subway.domain.option.MainOption;
import subway.view.InputView;
import subway.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {

        InitialSettingController initialSettingController = new InitialSettingController();

        outputView.printMainScreen();
        MainOption mainOption = inputView.readMainOption();
        System.out.println(mainOption);

    }
}