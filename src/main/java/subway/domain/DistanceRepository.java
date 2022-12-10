package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.station.Station;

public class DistanceRepository {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(
            DefaultWeightedEdge.class);

    public static void addStation(Station station) {
        distanceGraph.addVertex(station.getName());
    }

    public static void addDistance(Station station1, Station station2, int distance) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(station1.getName(), station2.getName()), distance);
    }

    public static List<String> getShortestDistance(Station departure, Station arrival) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        return dijkstraShortestPath.getPath(departure.getName(), arrival.getName()).getVertexList();
    }
}
