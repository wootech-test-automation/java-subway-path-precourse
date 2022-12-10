package subway.domain;

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
}
