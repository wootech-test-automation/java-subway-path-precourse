package subway.domain.graph;

import java.util.List;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.type.PathResult;
import subway.domain.type.Section;
import subway.domain.type.Station;

public class DefaultPathFinderImpl implements PathFinder {

    private static final String ERROR_MESSAGE = "출발역과 도착역이 같을 수 없습니다.";
    private final DijkstraShortestPath<Station, Section> dijkstraShortestPath;

    public DefaultPathFinderImpl(WeightedMultigraph<Station, Section> graph) {
        this.dijkstraShortestPath = new DijkstraShortestPath<>(graph);
    }

    @Override
    public PathResult getPathResult(Station source, Station target) {
        GraphPath<Station, Section> path = dijkstraShortestPath.getPath(source, target);
        List<Station> stations = path.getVertexList();
        int totalDistance = getTotalDistance(path);
        int totalTime = getTotalTime(path);
        return new PathResult(stations, totalDistance, totalTime);
    }

    private int getTotalDistance(GraphPath<Station, Section> path) {
        List<Section> edgeList = path.getEdgeList();
        return edgeList.stream().map(Section::getDistance)
                .reduce(Integer::sum)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
    }

    private int getTotalTime(GraphPath<Station, Section> path) {
        List<Section> edgeList = path.getEdgeList();
        return edgeList.stream().map(Section::getTime)
                .reduce(Integer::sum)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
    }
}
