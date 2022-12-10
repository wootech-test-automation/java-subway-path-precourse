package subway.controller;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.*;

public class InitialSettingController {

    private final List<Station> stations;
    private final List<Line> lines;
    private final WeightedMultigraph timeGraph;
    private WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph;

    public InitialSettingController() {
        this.stations = initializeStations();
        this.lines = initializeLines();
        this.distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        this.timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    }

    private List<Station> initializeStations() {
        List<String> stations = new ArrayList<>(List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
        stations.stream().map(Station::new).forEach(StationRepository::addStation);
        System.out.println(StationRepository.stations());
        return StationRepository.stations();
    }

    private List<Line> initializeLines() {
        List<String> lines = new ArrayList<>(List.of("2호선", "3호선", "신분당선"));
        lines.stream().map(Line::new).forEach(LineRepository::addLine);
     //   StationRepository.stations().stream().forEach(this::setStations);
        return LineRepository.lines();
    }


  /*  private void setStations(Station station) {
        distanceGraph.addVertex(station.getName());
    }

    public void getDistanceGraph() {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("v1", "v2"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("v2", "v3"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("v1", "v3"), 100);
    }*/
}
