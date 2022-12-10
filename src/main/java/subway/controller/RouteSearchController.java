package subway.controller;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.option.RouteOption;
import subway.domain.station.Station;
import subway.util.message.ExceptionMessage;
import subway.view.InputView;
import subway.view.OutputView;

public class RouteSearchController {

    public static final int DISTANCE_INDEX = 0;
    public static final int TIME_INDEX = 1;
    private final InputView inputView;
    private final OutputView outputView;

    private static final List<DijkstraShortestPath> paths = new ArrayList<>();


    public RouteSearchController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static void addToPath(DijkstraShortestPath path) {
        paths.add(path);
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
            if (routeOption == RouteOption.SHORTEST_DISTANCE) {
                DijkstraShortestPath path = paths.get(DISTANCE_INDEX);
                List<String> optimalRoute = path.getPath(departureStation.getName(), arrivalStation.getName())
                        .getVertexList();
                int totalDistance = (int) path.getPathWeight(departureStation.getName(), arrivalStation.getName());
                outputView.printQueryResult(totalDistance, optimalRoute);
            }
            if (routeOption == RouteOption.SHORTEST_TIME) {
                DijkstraShortestPath path = paths.get(TIME_INDEX);
                List<String> optimalRoute = path.getPath(departureStation.getName(), arrivalStation.getName())
                        .getVertexList();
                int totalTime = (int) path.getPathWeight(departureStation.getName(), arrivalStation.getName());
                outputView.printQueryResult(totalTime, optimalRoute);
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException(ExceptionMessage.PROBLEM_OCCURRED.getMessage());
        }

    }

    private static void validateDifferentDepartureAndArrivalStation(Station departureStation, Station arrivalStation) {
        if (departureStation == arrivalStation) {
            throw new IllegalArgumentException(
                    ExceptionMessage.INVALID_SAME_DEPARTURE_AND_ARRIVAL_STATION.getMessage());
        }
    }
}
