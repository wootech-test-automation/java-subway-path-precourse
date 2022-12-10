package subway.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.controller.InitialSettingController;
import subway.util.message.ExceptionMessage;

class StationRepositoryTest {

    @BeforeEach
    void setUp() {
        InitialSettingController.initialize();
    }

    @Nested
    class invalidInputTest {

        @ParameterizedTest
        @ValueSource(strings = {"없는역", "사당역"})
        @DisplayName("존재하지 않는 역의 경우 예외 처리한다.")
        void 자연수가_아닌_입력(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> StationRepository.findStationByName(input))
                    .withMessageStartingWith(ExceptionMessage.NO_SUCH_STATION.getMessage());
        }

    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"역삼역", "남부터미널역", "양재시민의숲역"})
        void 정상_입력(String input) {
            assertThatCode(() -> StationRepository.findStationByName(input))
                    .doesNotThrowAnyException();
        }

    }

}