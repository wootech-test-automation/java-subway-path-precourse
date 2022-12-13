package subway.domain.type;

import java.util.List;

public class PathFindResult {
    private final List<String> path;
    private int totalDistance = 0;
    private int totalTime = 0;

    public PathFindResult(List<String> path) {
        this.path = path;
    }

    public void addPrice(int distance, int time) {
        totalDistance += distance;
        totalTime += time;
    }

    public List<String> getPath() {
        return path;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getTotalTime() {
        return totalTime;
    }
}
