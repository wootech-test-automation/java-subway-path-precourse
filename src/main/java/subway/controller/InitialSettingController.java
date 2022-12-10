package subway.controller;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class InitialSettingController {

    public static final List<String> STATIONS = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    public static final List<String> LINES = List.of("2호선", "3호선", "신분당선");


    public static void initialize() {
        initializeStations();
        initializeLines();
        initializeDistanceRepository();
        initializeTimeRepository();
    }

    private static void initializeStations() {
        List<String> stations = new ArrayList<>(STATIONS);
        stations.stream().map(Station::new).forEach(StationRepository::addStation);
    }

    private static void initializeLines() {
        List<String> lines = new ArrayList<>(LINES);
        lines.stream().map(Line::new).forEach(LineRepository::addLine);
    }

    private static void initializeDistanceRepository() {
        WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = getGraphWithStations();
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("교대역", "강남역"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("강남역", "역삼역"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("교대역", "남부터미널역"), 3);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("남부터미널역", "양재역"), 6);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("양재역", "매봉역"), 1);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("강남역", "양재역"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("양재역", "양재시민의숲역"), 10);
        DijkstraShortestPath shortestDistance = new DijkstraShortestPath(distanceGraph);
        RouteSearchController.addToPath(shortestDistance);
    }

    private static void initializeTimeRepository() {
        WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = getGraphWithStations();
        timeGraph.setEdgeWeight(timeGraph.addEdge("교대역", "강남역"), 3);
        timeGraph.setEdgeWeight(timeGraph.addEdge("강남역", "역삼역"), 3);
        timeGraph.setEdgeWeight(timeGraph.addEdge("교대역", "남부터미널역"), 2);
        timeGraph.setEdgeWeight(timeGraph.addEdge("남부터미널역", "양재역"), 5);
        timeGraph.setEdgeWeight(timeGraph.addEdge("양재역", "매봉역"), 1);
        timeGraph.setEdgeWeight(timeGraph.addEdge("강남역", "양재역"), 8);
        timeGraph.setEdgeWeight(timeGraph.addEdge("양재역", "양재시민의숲역"), 3);
        DijkstraShortestPath shortestTime = new DijkstraShortestPath(timeGraph);
        RouteSearchController.addToPath(shortestTime);
    }

    private static WeightedMultigraph<String, DefaultWeightedEdge> getGraphWithStations() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }
        return graph;
    }

    private static Station station(String name) {
        return StationRepository.findStationByName(name);
    }

}
