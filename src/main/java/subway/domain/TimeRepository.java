package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.station.Station;

public class TimeRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(
            DefaultWeightedEdge.class);

    public static void addStation(Station station) {
        timeGraph.addVertex(station.getName());
    }

    public static void addTime(Station station1, Station station2, int time) {
        timeGraph.setEdgeWeight(timeGraph.addEdge(station1.getName(), station2.getName()), time);
    }

    public static List<String> getShortestTime(Station departure, Station arrival) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        return dijkstraShortestPath.getPath(departure.getName(), arrival.getName()).getVertexList();
    }



}
