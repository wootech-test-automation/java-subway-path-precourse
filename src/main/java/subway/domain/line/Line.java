package subway.domain.line;

import java.util.List;
import subway.domain.station.Station;

public class Line {
    private final String name;

    public Line(String name, List<Station> stations) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    // 추가 기능 구현
}
