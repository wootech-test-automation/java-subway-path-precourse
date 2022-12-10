package subway.domain;

import java.util.List;

public class Line {
    private final String name;
    private final List<Station> stations;

    public Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    // 추가 기능 구현
    public boolean compareOriginalStationIndexBeforeTargetStation(Station originalStation, Station targetStation ) {
        return stations.indexOf(originalStation) < stations.indexOf(targetStation);
    }
}
