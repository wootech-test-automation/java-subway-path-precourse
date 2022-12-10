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

public class ShortestTimePathService {
    private final static WeightedMultigraph<String, DefaultWeightedEdge> shortestTimes = new WeightedMultigraph<>(
            DefaultWeightedEdge.class);

    public static void initializePath() {
        addStations();
        addDistances();
    }

    private static void addDistances() {
        shortestTimes.setEdgeWeight(shortestTimes.addEdge(KYODAE.getName(), GANGNAM.getName()), 3);
        shortestTimes.setEdgeWeight(shortestTimes.addEdge(GANGNAM.getName(), YEOKSAM.getName()), 3);
        shortestTimes.setEdgeWeight(shortestTimes.addEdge(KYODAE.getName(), NAMBU_TERMINAL.getName()), 2);
        shortestTimes.setEdgeWeight(shortestTimes.addEdge(NAMBU_TERMINAL.getName(), YANGJE.getName()), 5);
        shortestTimes.setEdgeWeight(shortestTimes.addEdge(YANGJE.getName(), MAEBONG.getName()), 1);
        shortestTimes.setEdgeWeight(shortestTimes.addEdge(GANGNAM.getName(), YANGJE.getName()), 8);
        shortestTimes.setEdgeWeight(shortestTimes.addEdge(YANGJE.getName(), YANGJE_FOREST.getName()), 3);
    }

    private static void addStations() {
        shortestTimes.addVertex(KYODAE.getName());
        shortestTimes.addVertex(GANGNAM.getName());
        shortestTimes.addVertex(YEOKSAM.getName());
        shortestTimes.addVertex(NAMBU_TERMINAL.getName());
        shortestTimes.addVertex(YANGJE.getName());
        shortestTimes.addVertex(MAEBONG.getName());
        shortestTimes.addVertex(YANGJE_FOREST.getName());
    }
}
