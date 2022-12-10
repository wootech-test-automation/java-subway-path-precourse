package subway.controller;

import subway.domain.option.MainOption;
import subway.view.InputView;
import subway.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private MainOption mainOption;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        InitialSettingController.initialize();
        do {
            outputView.printMainScreen();
            mainOption = inputView.readMainOption();
            handleSearch();
        } while (!mainOption.isQuit());
    }

    private void handleSearch() {
        if (mainOption.isSearch()) {
            RouteSearchController routeSearchController = new RouteSearchController(inputView, outputView);
            routeSearchController.search();
        }
    }
}