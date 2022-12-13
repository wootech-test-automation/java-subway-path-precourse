package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import subway.domain.type.Line;
import subway.domain.type.PathFindResult;
import subway.domain.type.Route;
import subway.domain.type.Station;
import subway.repository.LineRepository;
import subway.repository.RouteRepository;
import subway.repository.StationRepository;
import subway.util.PathFinder;

public class SubwaySystem {
    public SubwaySystem() {
        initialize();
    }

    private void initialize() {
        List<Line> lines = Arrays.asList(
                new Line("2호선"),
                new Line("3호선"),
                new Line("신분당선")
        );
        LineRepository.addAll(lines);

        List<Station> stations = Arrays.asList(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("매봉역"),
                new Station("양재시민의숲역")
        );
        StationRepository.addAll(stations);

        List<Route> routes = Arrays.asList(
                makeRoute("교대역", "강남역", 2, 3),
                makeRoute("강남역", "역삼역", 2, 3),
                makeRoute("교대역", "남부터미널역", 6, 5),
                makeRoute("남부터미널역", "양재역", 6, 5),
                makeRoute("양재역", "매봉역", 1, 1),
                makeRoute("양재역", "양재시민의숲역", 10, 3),
                makeRoute("강남역", "양재역", 2, 8)
        );
        RouteRepository.addAll(routes);
    }

    private Route makeRoute(String startStationName, String endStationName, int distance, int time) {
        Station startStation = StationRepository.findByName(startStationName);
        Station endStation = StationRepository.findByName(endStationName);
        return new Route(startStation, endStation, distance, time);
    }

    public PathFindResult shortestRoute(String startStationName, String destinationStationName) {
        validateStationsName(startStationName, destinationStationName);
        List<String> paths = PathFinder.dijkstra(true, RouteRepository.routes(), startStationName,
                destinationStationName);
        return checkAllPaths(paths);
    }

    public PathFindResult fastestRoute(String startStationName, String destinationStationName) {
        validateStationsName(startStationName, destinationStationName);
        List<String> paths = PathFinder.dijkstra(false, RouteRepository.routes(), startStationName,
                destinationStationName);
        return checkAllPaths(paths);
    }

    private void validateStationsName(String startStationName, String destinationStationName) {
        if (startStationName.equals(destinationStationName)) {
            throw new IllegalArgumentException("시작역과 도착역의 이름이 같습니다. " + startStationName + destinationStationName);
        }
    }

    private PathFindResult checkAllPaths(List<String> paths) {
        PathFindResult result = new PathFindResult(paths);
        for (int i = 0; i < paths.size() - 1; i++) {
            String stationName1 = paths.get(i);
            String stationName2 = paths.get(i + 1);
            Route route = RouteRepository.findByStationsName(stationName1, stationName2);
            if (route != null) {
                result.addPrice(route.getDistance(), route.getTime());
            }
        }
        return result;
    }
}
