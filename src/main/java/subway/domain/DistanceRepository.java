package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DistanceRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(
            DefaultWeightedEdge.class);

    public DistanceRepository() {
    }


}
