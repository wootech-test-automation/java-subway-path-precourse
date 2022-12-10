package subway.domain.section;

import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.station.Station;
import subway.domain.weight.WeightCode;
import subway.domain.weight.WeightDivision;

public class Section extends DefaultWeightedEdge {
    private final Station firstEdgeStation;
    private final Station lastEdgeStation;
    private final WeightDivision weight;

    public Section(Station firstEdgeStation, Station lastEdgeStation, WeightDivision weight) {
        this.firstEdgeStation = firstEdgeStation;
        this.lastEdgeStation = lastEdgeStation;
        this.weight = weight;
    }

    public Station getFirstEdgeStation() {
        return firstEdgeStation;
    }

    public Station getLastEdgeStation() {
        return lastEdgeStation;
    }

    public double getWeight(WeightCode weight) {
        if(weight == WeightCode.DISTANCE) {
            return this.weight.getValue(WeightCode.DISTANCE);
        }
        return this.weight.getValue(WeightCode.TIME);
    }

}
