package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.enums.LineStatus;

public class LineService {

    public void initializeLine() {
        LineRepository.addLine(new Line(LineStatus.LINE_TWO));
        LineRepository.addLine(new Line(LineStatus.LINE_THREE));
        LineRepository.addLine(new Line(LineStatus.LINE_NEW_BUNDANG));
    }
}
