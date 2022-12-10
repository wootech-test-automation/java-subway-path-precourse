package subway.launcher.context;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.ResultDto;
import subway.domain.Station;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.StationDivision;
import subway.domain.weight.WeightCode;

public class SystemContext {
    WeightedMultigraph<Station, Section> graph = new WeightedMultigraph(Section.class);

    private StationDivision stationDivision;

    public void initializeStationDivision(StationDivision stationDivision) {
        this.stationDivision = stationDivision;
    }

    public ResultDto calculateShortestDistance(WeightCode code) {
        DijkstraShortestPath dijkstraShortestPath = getDijkstraShortestPath(code);
        var result= dijkstraShortestPath.getPath(stationDivision.getUpStation(), stationDivision.getTerminalStation());
        return getResultDto(result);
    }

    private ResultDto getResultDto(GraphPath result) {
        List<Section> edgeList = result.getEdgeList();
        var distanceSum= edgeList.stream().mapToDouble(s -> s.getWeight(WeightCode.DISTANCE)).sum();
        var timeSum = edgeList.stream().mapToDouble(s -> s.getWeight(WeightCode.TIME)).sum();
        return new ResultDto(distanceSum, timeSum, result.getVertexList());
    }

    private DijkstraShortestPath getDijkstraShortestPath(WeightCode code) {
        SectionRepository.sections().forEach(section -> {
            graph.addVertex(section.getFirstEdgeStation());
            graph.addVertex(section.getLastEdgeStation());
        });
        SectionRepository.sections().forEach(section -> graph.addEdge(section.getFirstEdgeStation(), section.getLastEdgeStation(), section));
        SectionRepository.sections().forEach(section -> graph.setEdgeWeight(section.getFirstEdgeStation(),section.getLastEdgeStation(), section.getWeight(code)));
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath;
    }
}
