package subway;

import java.util.Objects;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JGraphtTest {
    @Test
    public void getDijkstraShortestPath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();
        double pathWeight = dijkstraShortestPath.getPathWeight("v3", "v1");
        System.out.println(pathWeight);
        assertThat(shortestPath.size()).isEqualTo(3);
    }

    @Test
    public void test() {
        WeightedMultigraph<String, Sector> graph = new WeightedMultigraph<>(Sector.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");

        Sector sector = new Sector(new Edge("v1", "v2"), 10);
        graph.addEdge(sector.getEdge().getVertex1(), sector.getEdge().getVertex2(), sector);
        graph.setEdgeWeight(sector, sector.getCost());

        DijkstraShortestPath<String, Sector> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        GraphPath<String, Sector> path = dijkstraShortestPath.getPath("v2", "v1");
        System.out.println(dijkstraShortestPath.getPathWeight("v2","v1"));
        System.out.println(path.getVertexList());
        System.out.println(path.getEdgeList());
        System.out.println(path.getWeight());

    }

    static class Sector {
        Edge edge;
        int cost;

        public Sector(Edge edge, int cost) {
            this.edge = edge;
            this.cost = cost;
        }

        public Edge getEdge() {
            return edge;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public String toString() {
            return "Sector{" +
                    "edge=" + edge +
                    ", cost=" + cost +
                    '}';
        }
    }

    static class Edge {
        String vertex1;
        String vertex2;

        public Edge(String vertex1, String vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Edge edge = (Edge) o;
            return Objects.equals(vertex1, edge.vertex1) && Objects.equals(vertex2, edge.vertex2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertex1, vertex2);
        }

        public String getVertex1() {
            return vertex1;
        }

        public String getVertex2() {
            return vertex2;
        }
    }
}
