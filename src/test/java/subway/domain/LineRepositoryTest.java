package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.enums.LineStatus;

class LineRepositoryTest {

    @BeforeEach
    void clearRepository() {
        LineRepository.deleteAll();
    }

    @Test
    @DisplayName("라인 추가 테스트")
    void addLine() {
        // given
        LineRepository.addLine(new Line(LineStatus.LINE_TWO));
        LineRepository.addLine(new Line(LineStatus.LINE_THREE));
        LineRepository.addLine(new Line(LineStatus.LINE_NEW_BUNDANG));

        // when
        List<Line> lines = LineRepository.lines();

        // then
        assertThat(lines.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("라인 삭제 테스트")
    void deleteLineByName() {
        // given
        LineRepository.addLine(new Line(LineStatus.LINE_TWO));
        LineRepository.addLine(new Line(LineStatus.LINE_THREE));
        LineRepository.addLine(new Line(LineStatus.LINE_NEW_BUNDANG));

        // when
        LineRepository.deleteLineByName("2호선");
        LineRepository.deleteLineByName("3호선");
        LineRepository.deleteLineByName("신분당선");
        List<Line> lines = LineRepository.lines();

        // then
        assertThat(lines.size()).isEqualTo(0);
    }
}