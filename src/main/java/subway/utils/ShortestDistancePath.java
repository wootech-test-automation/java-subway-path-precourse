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
import java.util.Objects;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;

public class ShortestDistancePath {
    private static final int START = 0;
    private static final int END = 1;

    private static final WeightedMultigraph<String, DefaultWeightedEdge> shortestDistances = new WeightedMultigraph<>(
            DefaultWeightedEdge.class);

    public static void initializePath() {
        if (!shortestDistances.vertexSet().isEmpty()) {
            return;
        }
        addStations();
        addDistances();
    }

    private static void addDistances() {
        shortestDistances.setEdgeWeight(shortestDistances.addEdge(KYODAE.getName(), GANGNAM.getName()), 2);
        shortestDistances.setEdgeWeight(shortestDistances.addEdge(GANGNAM.getName(), YEOKSAM.getName()), 2);
        shortestDistances.setEdgeWeight(shortestDistances.addEdge(KYODAE.getName(), NAMBU_TERMINAL.getName()), 3);
        shortestDistances.setEdgeWeight(shortestDistances.addEdge(NAMBU_TERMINAL.getName(), YANGJE.getName()), 6);
        shortestDistances.setEdgeWeight(shortestDistances.addEdge(YANGJE.getName(), MAEBONG.getName()), 1);
        shortestDistances.setEdgeWeight(shortestDistances.addEdge(GANGNAM.getName(), YANGJE.getName()), 2);
        shortestDistances.setEdgeWeight(shortestDistances.addEdge(YANGJE.getName(), YANGJE_FOREST.getName()), 10);
    }

    private static void addStations() {
        shortestDistances.addVertex(KYODAE.getName());
        shortestDistances.addVertex(GANGNAM.getName());
        shortestDistances.addVertex(YEOKSAM.getName());
        shortestDistances.addVertex(NAMBU_TERMINAL.getName());
        shortestDistances.addVertex(YANGJE.getName());
        shortestDistances.addVertex(MAEBONG.getName());
        shortestDistances.addVertex(YANGJE_FOREST.getName());
    }

    public static List<Object> createResultList(final List<Station> stations) {
        List<Object> results = new ArrayList<>();
        results.add(calculateShortestDistance(stations.get(START), stations.get(END)));
        results.add(calculateTime(createVertexList(stations.get(START), stations.get(END))));
        results.add(createVertexList(stations.get(START), stations.get(END)));
        return results;
    }

    private static int calculateTime(final List vertexes) {
        return MinimumTimePath.calculateTimeByVertexes(vertexes);
    }

    private static List createVertexList(final Station startStation, final Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(shortestDistances);
        GraphPath path = dijkstraShortestPath.getPath(startStation.getName(), endStation.getName());
        return path.getVertexList();
    }

    private static int calculateShortestDistance(final Station startStation, final Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(shortestDistances);
        GraphPath path = dijkstraShortestPath.getPath(startStation.getName(), endStation.getName());
        return (int) path.getWeight();
    }

    public static int calculateDistanceByVertexes(final List<String> vertexes) {
        int distanceSum = 0;
        for (int index = 0; index < vertexes.size() - 1; index++) {
            distanceSum += shortestDistances.getEdgeWeight(shortestDistances.getEdge(vertexes.get(index), vertexes.get(index + 1)));
        }
        return distanceSum;
    }
}
