package subway.domain.graph;

import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.repository.SectionRepository;
import subway.domain.repository.StationRepository;
import subway.domain.type.Section;
import subway.domain.type.Station;

public class DefaultGraphMakerImpl implements GraphMaker {

    private static final String ERROR_MESSAGE = "distance와 time만 입력 가능합니다.";

    @Override
    public WeightedMultigraph<Station, Section> make(String option) {
        if (option.equals("distance")) {
            return makeDistanceGraph();
        }
        if (option.equals("time")) {
            return makeTimeGraph();
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    private WeightedMultigraph<Station, Section> makeDistanceGraph() {
        WeightedMultigraph<Station, Section> graph = new WeightedMultigraph<>(Section.class);
        StationRepository.stations().forEach(graph::addVertex);
        SectionRepository.sections().forEach(section -> {
            graph.addEdge(section.getSource(), section.getTarget(), section);
            graph.setEdgeWeight(section, section.getDistance());
        });
        return graph;
    }

    private WeightedMultigraph<Station, Section> makeTimeGraph() {
        WeightedMultigraph<Station, Section> graph = new WeightedMultigraph<>(Section.class);
        StationRepository.stations().forEach(graph::addVertex);
        SectionRepository.sections().forEach(section -> {
            graph.addEdge(section.getSource(), section.getTarget(), section);
            graph.setEdgeWeight(section, section.getTime());
        });
        return graph;
    }
}
