package subway.domain.line;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private final List<Line> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addStations(List<String> input) {
        input.stream().map(LineRepository::findLineByName)
                .forEach(stations::add);
    }

    @Override
    public String toString() {
        return "Line{" +
                "name='" + name + '\'' +
                '}';
    }
}
