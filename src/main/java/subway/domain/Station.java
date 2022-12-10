package subway.domain;

import subway.domain.enums.StationStatus;

public class Station {
    private StationStatus station;

    public Station(StationStatus station) {
        this.station = station;
    }

    public String getName() {
        return station.getName();
    }

    public StationStatus getStation() {
        return station;
    }

    public boolean contains(final String stationName) {
        return station.getName().equals(stationName);
    }

    // 추가 기능 구현
}
