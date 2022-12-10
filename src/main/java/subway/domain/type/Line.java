package subway.domain.type;

import java.util.Objects;

public class Line {
    private final String name;
    private final Station source;
    private final Station target;

    public Line(String name, Station source, Station target) {
        this.name = name;
        this.source = source;
        this.target = target;
    }

    public static Line of(String name, String source, String target) {
        return new Line(name, new Station(source), new Station(target));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(name, line.name) && Objects.equals(source, line.source)
                && Objects.equals(target, line.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, source, target);
    }

    public String getName() {
        return name;
    }

    public Station getSource() {
        return source;
    }

    public Station getTarget() {
        return target;
    }
}
