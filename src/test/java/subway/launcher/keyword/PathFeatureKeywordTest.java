package subway.launcher.keyword;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PathFeatureKeywordTest {
    @ParameterizedTest
    @CsvSource({
            "12", "adf", "q", "#", "q"
    })
    void shouldThrowIllegalInput(String input) {
        assertThatThrownBy(() -> PathFeatureKeyword.nameOf(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1,2,B만 입력해주세요.");
    }
}