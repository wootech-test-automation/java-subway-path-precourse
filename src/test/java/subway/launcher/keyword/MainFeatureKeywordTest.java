package subway.launcher.keyword;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MainFeatureKeywordTest {

    @ParameterizedTest
    @CsvSource({
            "12", "adf", "q", "#", "q"
    })
    void shouldThrowIllegalInput(String input) {
        assertThatThrownBy(() -> MainFeatureKeyword.nameOf(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1, Q만 입력해주세요.");
    }
}