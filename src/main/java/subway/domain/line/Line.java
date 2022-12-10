package subway.domain.line;

import java.util.ArrayList;
import java.util.List;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class Line {
    private String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addStations(List<String> input) {
        input.stream()
                .map(StationRepository::findStationByName)
                .forEach(stations::add);
    }

    public List<Station> getStations() {
        return stations;
    }

    @Override
    public String toString() {
        return "Line{" +
                "name='" + name + '\'' +
                '}';
    }
}
