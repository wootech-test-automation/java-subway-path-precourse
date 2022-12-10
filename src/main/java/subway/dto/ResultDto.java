package subway.dto;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.station.Station;

public class ResultDto {
    private final int distanceSum;
    private final int timeSum;
    private final List<String> stationName;

    public ResultDto(double distanceSum, double timeSum, List<Station> stationName) {
        this.distanceSum = (int) distanceSum;
        this.timeSum = (int) timeSum;
        this.stationName = stationName.stream().map(Station::getName).collect(Collectors.toList());
    }

    public int getDistanceSum() {
        return distanceSum;
    }

    public int getTimeSum() {
        return timeSum;
    }

    public List<String> getStationName() {
        return stationName;
    }
}
