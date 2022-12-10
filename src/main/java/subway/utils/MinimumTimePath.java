package subway.utils;

import static subway.domain.enums.StationStatus.GANGNAM;
import static subway.domain.enums.StationStatus.KYODAE;
import static subway.domain.enums.StationStatus.MAEBONG;
import static subway.domain.enums.StationStatus.NAMBU_TERMINAL;
import static subway.domain.enums.StationStatus.YANGJE;
import static subway.domain.enums.StationStatus.YANGJE_FOREST;
import static subway.domain.enums.StationStatus.YEOKSAM;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;

public class MinimumTimePath {
    private static final int START = 0;
    private static final int END = 1;

    private static final WeightedMultigraph<String, DefaultWeightedEdge> minimumTimes = new WeightedMultigraph<>(
            DefaultWeightedEdge.class);

    public static void initializePath() {
        if (!minimumTimes.vertexSet().isEmpty()) {
            return;
        }
        addStations();
        addDistances();

    }

    private static void addDistances() {
        minimumTimes.setEdgeWeight(minimumTimes.addEdge(KYODAE.getName(), GANGNAM.getName()), 3);
        minimumTimes.setEdgeWeight(minimumTimes.addEdge(GANGNAM.getName(), YEOKSAM.getName()), 3);
        minimumTimes.setEdgeWeight(minimumTimes.addEdge(KYODAE.getName(), NAMBU_TERMINAL.getName()), 2);
        minimumTimes.setEdgeWeight(minimumTimes.addEdge(NAMBU_TERMINAL.getName(), YANGJE.getName()), 5);
        minimumTimes.setEdgeWeight(minimumTimes.addEdge(YANGJE.getName(), MAEBONG.getName()), 1);
        minimumTimes.setEdgeWeight(minimumTimes.addEdge(GANGNAM.getName(), YANGJE.getName()), 8);
        minimumTimes.setEdgeWeight(minimumTimes.addEdge(YANGJE.getName(), YANGJE_FOREST.getName()), 3);
    }

    private static void addStations() {
        minimumTimes.addVertex(KYODAE.getName());
        minimumTimes.addVertex(GANGNAM.getName());
        minimumTimes.addVertex(YEOKSAM.getName());
        minimumTimes.addVertex(NAMBU_TERMINAL.getName());
        minimumTimes.addVertex(YANGJE.getName());
        minimumTimes.addVertex(MAEBONG.getName());
        minimumTimes.addVertex(YANGJE_FOREST.getName());
    }

    public static int calculateTimeByVertexes(final List<String> vertexes) {
        int timeSum = 0;
        for (int index = 0; index < vertexes.size() - 1; index++) {
            timeSum += minimumTimes.getEdgeWeight(minimumTimes.getEdge(vertexes.get(index), vertexes.get(index + 1)));
        }
        return timeSum;
    }

    public static List<Object> createResultList(final List<Station> stations) {
        List<Object> results = new ArrayList<>();
        results.add(calculateDistance(createVertexList(stations.get(START), stations.get(END))));
        results.add(calculateMinimumTime(stations.get(START), stations.get(END)));
        results.add(createVertexList(stations.get(START), stations.get(END)));
        return results;
    }

    private static int calculateDistance(final List vertexes) {
        return ShortestDistancePath.calculateDistanceByVertexes(vertexes);
    }

    private static List createVertexList(final Station startStation, final Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(minimumTimes);
        GraphPath path = dijkstraShortestPath.getPath(startStation.getName(), endStation.getName());
        return path.getVertexList();
    }

    private static int calculateMinimumTime(final Station startStation, final Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(minimumTimes);
        GraphPath path = dijkstraShortestPath.getPath(startStation.getName(), endStation.getName());
        return (int) path.getWeight();
    }
}
