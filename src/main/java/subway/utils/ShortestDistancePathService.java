package subway.utils;

import static subway.domain.enums.StationStatus.GANGNAM;
import static subway.domain.enums.StationStatus.KYODAE;
import static subway.domain.enums.StationStatus.MAEBONG;
import static subway.domain.enums.StationStatus.NAMBU_TERMINAL;
import static subway.domain.enums.StationStatus.YANGJE;
import static subway.domain.enums.StationStatus.YANGJE_FOREST;
import static subway.domain.enums.StationStatus.YEOKSAM;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class ShortestDistancePathService {
    private final static WeightedMultigraph<String, DefaultWeightedEdge> shortestDistances = new WeightedMultigraph<>(
            DefaultWeightedEdge.class);

    public static void initializePath() {
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
}
