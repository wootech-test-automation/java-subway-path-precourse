package subway.domain;

import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.graph.DefaultGraphMakerImpl;
import subway.domain.graph.DefaultPathFinderImpl;
import subway.domain.graph.GraphMaker;
import subway.domain.graph.PathFinder;
import subway.domain.type.PathResult;
import subway.domain.type.Section;
import subway.domain.type.Station;

public class SubwayGame {

    private final GraphMaker graphMaker = new DefaultGraphMakerImpl();

    public PathResult getShortestPathByDistance(Station source, Station target) {
        WeightedMultigraph<Station, Section> graph = graphMaker.make("distance");
        PathFinder pathFinder = new DefaultPathFinderImpl(graph);
        return pathFinder.getPathResult(source, target);
    }

    public PathResult getShortestPathByTime(Station source, Station target) {
        WeightedMultigraph<Station, Section> graph = graphMaker.make("time");
        PathFinder pathFinder = new DefaultPathFinderImpl(graph);
        return pathFinder.getPathResult(source, target);
    }
}
