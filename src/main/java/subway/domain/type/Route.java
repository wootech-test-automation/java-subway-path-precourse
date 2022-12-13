package subway.domain.type;

import java.util.List;

public class Route {
    private final Station startStation;
    private final Station destinationStation;
    private final int distance;
    private final int time;

    public Route(Station startStation, Station destinationStation, int distance, int time) {
        this.startStation = startStation;
        this.destinationStation = destinationStation;
        this.distance = distance;
        this.time = time;
    }

    public List<String> getStationsName() {
        return List.of(startStation.getName(), destinationStation.getName());
    }

    public Station getStartStation() {
        return startStation;
    }

    public Station getDestinationStation() {
        return destinationStation;
    }

    public int getPrice(boolean isDistance) {
        if (isDistance) {
            return getDistance();
        }
        return getTime();
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return startStation + "->" + destinationStation + " " + distance + "km " + time + "분 소요";
    }
}
