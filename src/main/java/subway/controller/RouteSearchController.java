package subway.controller;

import subway.domain.option.RouteOption;
import subway.view.InputView;
import subway.view.OutputView;

public class RouteSearchController {

    private final InputView inputView;
    private final OutputView outputView;

    public RouteSearchController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void search() {
        outputView.printRouteOption();
        RouteOption routeOption = inputView.readRouteOption();

    }
}
