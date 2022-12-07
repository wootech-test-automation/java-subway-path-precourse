package subway;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    void 정상적으로_동작_하는가() {
        run("1", "1", "교대역", "양재역", "Q");
        var expected = List.of(
                "[INFO] ---",
                "[INFO] 총 거리: 4km",
                "[INFO] 총 소요 시간: 11분",
                "[INFO] ---",
                "[INFO] 교대역",
                "[INFO] 강남역",
                "[INFO] 양재역"
        );
        assertThat(output()).contains(expected);
    }

    @Test
    void 에러처리() {
        assertSimpleTest(
                () -> {
                    runException("1", "1", "강남역", "강남역");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
