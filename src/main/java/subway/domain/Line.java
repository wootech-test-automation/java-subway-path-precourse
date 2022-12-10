package subway.domain;

import subway.domain.enums.LineStatus;

public class Line {
    private LineStatus line;

    public Line(LineStatus line) {
        this.line = line;
    }

    public String getName() {
        return line.getName();
    }

    public LineStatus getLine() {
        return line;
    }

}