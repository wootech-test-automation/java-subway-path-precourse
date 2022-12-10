package subway.controller;

import subway.domain.station.Station;
import subway.domain.option.RouteOption;
import subway.util.message.ExceptionMessage;
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

        Station departureStation = inputView.readDepartureStation();
        System.out.println(departureStation);

        Station arrivalStation = inputView.readArrivalStation();
        System.out.println(arrivalStation);

        validateDifferentDepartureAndArrivalStation(departureStation, arrivalStation);
    }

    private static void validateDifferentDepartureAndArrivalStation(Station departureStation, Station arrivalStation) {
        if (departureStation == arrivalStation) {
            throw new IllegalArgumentException(
                    ExceptionMessage.INVALID_SAME_DEPARTURE_AND_ARRIVAL_STATION.getMessage());
        }
    }
}
