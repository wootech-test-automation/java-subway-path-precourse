package subway.launcher.context;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.line.LineRepository;
import subway.dto.ResultDto;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.StationDivision;
import subway.domain.weight.WeightCode;

public class SystemContext {
    WeightedMultigraph<Station, Section> graph = new WeightedMultigraph(Section.class);

    private StationDivision stationDivision;

    public void initializeStationDivision(StationDivision stationDivision) {

        LineRepository.existsSameLine(stationDivision.getUpStation(), stationDivision.getTerminalStation());
        this.stationDivision = stationDivision;
    }

    public ResultDto calculateShortestByWeight(WeightCode code) {
        try {
            DijkstraShortestPath dijkstraShortestPath = getDijkstraShortestPath(code);
            var result = dijkstraShortestPath.getPath(
                    stationDivision.getUpStation(), stationDivision.getTerminalStation()
            );
            return generateResultDto(result.getEdgeList(), result.getVertexList());
        }catch (IllegalArgumentException exception){
            throw new IllegalStateException("연결할 수 없는 역입니다.");
        }
    }

    private ResultDto generateResultDto(List<Section> edgeList, List<Station> stationList) {
        var distanceSum= edgeList.stream().mapToDouble(s -> s.getWeight(WeightCode.DISTANCE)).sum();
        var timeSum = edgeList.stream().mapToDouble(s -> s.getWeight(WeightCode.TIME)).sum();
        return new ResultDto(distanceSum, timeSum,stationList);
    }

    private DijkstraShortestPath getDijkstraShortestPath(WeightCode code) {
        SectionRepository.sections().forEach(section -> {
            graph.addVertex(section.getFirstEdgeStation());
            graph.addVertex(section.getLastEdgeStation());
            graph.addEdge(section.getFirstEdgeStation(), section.getLastEdgeStation(),section);
            graph.setEdgeWeight(section.getFirstEdgeStation(),section.getLastEdgeStation(),section.getWeight(code));
        });
        return new DijkstraShortestPath(graph);
    }

    public void validateExistsStation(Station station) {
        StationRepository.existsByStation(station);
    }
}
