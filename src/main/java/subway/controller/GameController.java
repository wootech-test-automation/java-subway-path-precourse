package subway.controller;

import subway.domain.option.MainOption;
import subway.domain.option.RouteOption;
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

        InitialSettingController initialSettingController = new InitialSettingController();

        do {
            outputView.printMainScreen();
            mainOption = inputView.readMainOption();
            System.out.println(mainOption);

            if (mainOption == MainOption.ROUTE_SEARCH) {
                RouteSearchController routeSearchController = new RouteSearchController(inputView, outputView);
                routeSearchController.search();
            }

        } while (mainOption != MainOption.QUIT);
    }
}