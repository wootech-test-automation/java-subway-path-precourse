package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;
    private final List<Line> lines = new ArrayList<>();

    public Station(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addLines(List<String> input) {
        input.stream().map(LineRepository::findLineByName)
                .forEach(lines::add);
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", lines=" + lines +
                '}';
    }
}
