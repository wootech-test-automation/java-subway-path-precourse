package subway.util;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.type.PathFindResult;
import subway.domain.type.Route;

public class PathFinder {
    public static List<String> dijkstra(boolean wantShortest, List<Route> routes, String startStation, String destinationStation) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (Route route : routes) {
            String startStationName = route.getStartStation().getName();
            String destinationStationName = route.getDestinationStation().getName();
            graph.addVertex(startStationName);
            graph.addVertex(destinationStationName);
            graph.setEdgeWeight(graph.addEdge(startStationName, destinationStationName), route.getPrice(wantShortest));
        }

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation, destinationStation).getVertexList();
        return shortestPath;
    }

}
