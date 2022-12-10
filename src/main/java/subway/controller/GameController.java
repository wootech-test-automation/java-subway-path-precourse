package subway.controller;

import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;
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
        System.out.println(StationRepository.stations());
        System.out.println(LineRepository.lines());

        do {
            outputView.printMainScreen();
            mainOption = inputView.readMainOption();

            if (mainOption == MainOption.ROUTE_SEARCH) {
                RouteSearchController routeSearchController = new RouteSearchController(inputView, outputView);
                routeSearchController.search();
            }

        } while (mainOption != MainOption.QUIT);
    }
}