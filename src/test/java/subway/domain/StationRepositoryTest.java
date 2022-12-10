package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.enums.StationStatus;

class StationRepositoryTest {
    @BeforeEach
    void clearRepository() {
        StationRepository.deleteAll();
    }

    @Test
    @DisplayName("라인 추가 테스트")
    void addLine() {
        // given
        StationRepository.addStation(new Station(StationStatus.KYODAE));
        StationRepository.addStation(new Station(StationStatus.GANGNAM));
        StationRepository.addStation(new Station(StationStatus.YEOKSAM));

        // when
        List<Station> stations = StationRepository.stations();

        // then
        assertThat(stations.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("라인 삭제 테스트")
    void deleteLineByName() {
        // given
        StationRepository.addStation(new Station(StationStatus.KYODAE));
        StationRepository.addStation(new Station(StationStatus.GANGNAM));
        StationRepository.addStation(new Station(StationStatus.YEOKSAM));

        // when
        StationRepository.deleteStation("교대역");
        StationRepository.deleteStation("강남역");
        StationRepository.deleteStation("역삼역");
        List<Station> stations = StationRepository.stations();

        // then
        assertThat(stations.size()).isEqualTo(0);
    }
}