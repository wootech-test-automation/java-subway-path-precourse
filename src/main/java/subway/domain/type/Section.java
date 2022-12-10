package subway.domain.type;

import java.util.Objects;

public class Section {
    private final Line line;
    private final int distance;
    private final int time;


    public Section(Line line, int distance, int time) {
        this.line = line;
        this.distance = distance;
        this.time = time;
    }

    public static Section of(Line line, int distance, int time) {
        return new Section(line, distance, time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Section section = (Section) o;
        return distance == section.distance && time == section.time && Objects.equals(line, section.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, distance, time);
    }

    public Line getLine() {
        return line;
    }

    public Station getSource() {
        return line.getSource();
    }

    public Station getTarget() {
        return line.getTarget();
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
