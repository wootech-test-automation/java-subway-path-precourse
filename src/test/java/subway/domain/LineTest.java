package subway.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import subway.domain.line.Line;
import subway.domain.station.Station;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineTest {

    @Test
    void 상행역이_종행역보다_앞에_와야합니다() {
        var line = new Line("3호선", List.of
                (new Station("교대역"), new Station("남부터미널역"), new Station("양재역"), new Station("매봉역")));

    }

}