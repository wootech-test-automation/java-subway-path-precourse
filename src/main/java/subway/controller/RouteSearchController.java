package subway.controller;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.DistanceRepository;
import subway.domain.TimeRepository;
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

        try {
            List<String> optimalRoute = new ArrayList<>();
            if (routeOption == RouteOption.SHORTEST_DISTANCE) {
                optimalRoute = DistanceRepository.getShortestDistance(departureStation, arrivalStation);
            }
            if (routeOption == RouteOption.SHORTEST_TIME) {
                optimalRoute = TimeRepository.getShortestTime(departureStation, arrivalStation);
            }
            System.out.println(optimalRoute);
        } catch (Exception exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NO_CONNECTION_BETWEEN_STATIONS.getMessage());
        }

    }

    private static void validateDifferentDepartureAndArrivalStation(Station departureStation, Station arrivalStation) {
        if (departureStation == arrivalStation) {
            throw new IllegalArgumentException(
                    ExceptionMessage.INVALID_SAME_DEPARTURE_AND_ARRIVAL_STATION.getMessage());
        }
    }
}
