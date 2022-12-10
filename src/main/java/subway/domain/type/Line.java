package subway.domain.type;

public class Line {
    private final String name;
    private final Station source;
    private final Station target;
    private final int distance;
    private final int time;

    public Line(String name, Station source, Station target, int distance, int time) {
        this.name = name;
        this.source = source;
        this.target = target;
        this.distance = distance;
        this.time = time;
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

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
