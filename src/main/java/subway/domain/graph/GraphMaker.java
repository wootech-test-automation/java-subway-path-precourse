package subway.domain.graph;

import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.type.Section;
import subway.domain.type.Station;

@FunctionalInterface
public interface GraphMaker {

    WeightedMultigraph<Station, Section> make(String option);
}
