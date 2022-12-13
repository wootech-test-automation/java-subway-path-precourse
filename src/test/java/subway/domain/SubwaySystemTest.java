package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.type.PathFindResult;

class SubwaySystemTest {
    SubwaySystem subwaySystem;

    @BeforeEach
    void beforeEach() throws Exception {
        subwaySystem = new SubwaySystem();
    }

    @CsvSource(value = {"강남역:매봉역:3:9", "양재시민의숲역:매봉역:11:4", "역삼역:남부터미널역:10:11", "교대역:양재역:4:11"}, delimiter = ':')
    @ParameterizedTest
    void shortestRoute_정상입력_정상(String stationName1, String stationName2, int targetDistance, int targetTime) {
        PathFindResult pathFindResult = subwaySystem.shortestRoute(stationName1, stationName2);
        assertThat(pathFindResult.getTotalDistance()).isEqualTo(targetDistance);
        assertThat(pathFindResult.getTotalTime()).isEqualTo(targetTime);
    }

    @CsvSource(value = {"강남역:매봉역:3:9", "양재시민의숲역:매봉역:11:4", "역삼역:남부터미널역:10:11", "교대역:양재역:12:10"}, delimiter = ':')
    @ParameterizedTest
    void fastestRoute_정상입력_정상(String stationName1, String stationName2, int targetDistance, int targetTime){
            PathFindResult pathFindResult = subwaySystem.fastestRoute(stationName1, stationName2);
            assertThat(pathFindResult.getTotalDistance()).isEqualTo(targetDistance);
            assertThat(pathFindResult.getTotalTime()).isEqualTo(targetTime);
    }

    @ValueSource(strings = {"강남역", "양재시민의숲역", "남부터미널역"})
    @ParameterizedTest
    void shortestRoute_역이름중복입력_예외(String stationName) {
        assertThatThrownBy(() -> {
            PathFindResult pathFindResult = subwaySystem.shortestRoute(stationName, stationName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"강남역", "양재시민의숲역", "남부터미널역"})
    @ParameterizedTest
    void fastestRoute_역이름중복입력_예외(String stationName) {
        assertThatThrownBy(() -> {
            PathFindResult pathFindResult = subwaySystem.fastestRoute(stationName, stationName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"갱갱역", "인천역", "으악", "123", "가나다라마바사아자차카타파하", "강남"})
    @ParameterizedTest
    void shortestRoute_목록에없는역입력_예외(String stationName) {
        assertThatThrownBy(() -> {
            PathFindResult pathFindResult = subwaySystem.shortestRoute("강남역", stationName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"갱갱역", "인천역", "으악", "123", "가나다라마바사아자차카타파하", "강남"})
    @ParameterizedTest
    void fastestRoute_목록에없는역입력_예외(String stationName) {
        assertThatThrownBy(() -> {
            PathFindResult pathFindResult = subwaySystem.fastestRoute("강남역", stationName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}