package subway.domain.type;

import java.util.List;

public class PathResult {

    private final List<Station> shortestPath;
    private final int totalDistance;
    private final int totalTime;

    public PathResult(List<Station> shortestPath, int totalDistance, int totalTime) {
        this.shortestPath = shortestPath;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
    }

    public List<Station> getShortestPath() {
        return shortestPath;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getTotalTime() {
        return totalTime;
    }

    @Override
    public String toString() {
        return "PathResult{"
                + "shortestPath=" + shortestPath
                + ", totalDistance=" + totalDistance
                + ", totalTime=" + totalTime
                + '}';
    }
}
