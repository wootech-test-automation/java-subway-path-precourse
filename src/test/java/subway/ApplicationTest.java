package subway;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    void 정상적으로_동작_하는가() {
        run("1", "1", "잠실역", "1", "3", "1", "2", "잠실역", "2", "1", "1호선", "강남역", "잠실역", "2", "3", "2", "2", "1호선", "3", "1", "2호선", "잠실역", "2", "3", "2", "2호선", "잠실역", "4", "Q");
        var expected = List.of(
                 "[INFO] 지하철 역이 등록되었습니다.",
                 "[INFO] 교대역",
                 "[INFO] 강남역",
                 "[INFO] 역삼역",
                 "[INFO] 남부터미널역",
                 "[INFO] 양재역",
                 "[INFO] 양재시민의숲역",
                 "[INFO] 매봉역",
                 "[INFO] 잠실역",
                 "[INFO] 지하철 역이 삭제되었습니다.",
                 "[INFO] 지하철 노선이 등록되었습니다.",
                 "[INFO] 2호선",
                 "[INFO] 3호선",
                 "[INFO] 신분당선",
                 "[INFO] 1호선",
                 "[INFO] 지하철 노선이 삭제되었습니다.",
                 "[INFO] 구간이 등록되었습니다.",
                 "[INFO] 구간이 삭제되었습니다.",
                 "[INFO] 2호선",
                 "[INFO] ---",
                 "[INFO] 교대역",
                 "[INFO] 강남역",
                 "[INFO] 역삼역",
                 "[INFO] 3호선",
                 "[INFO] ---",
                 "[INFO] 교대역",
                 "[INFO] 남부터미널역",
                 "[INFO] 양재역",
                 "[INFO] 매봉역",
                 "[INFO] 신분당선",
                 "[INFO] ---",
                 "[INFO] 강남역",
                 "[INFO] 양재역",
                 "[INFO] 양재시민의숲역"
        );
        assertThat(output()).contains(expected);
    }

    @Test
    void 에러처리() {
        assertSimpleTest(
                () -> {
                    runException("5");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
