package subway.domain;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.section.Section;

public class ResultDto {
    private int distanceSum;
    private int timeSum;
    private List<String> stationName;

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
