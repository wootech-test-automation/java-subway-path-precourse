package subway.service;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.enums.StationStatus;

public class StationService {

    public void initializeStation() {
        StationRepository.addStation(new Station(StationStatus.KYODAE));
        StationRepository.addStation(new Station(StationStatus.GANGNAM));
        StationRepository.addStation(new Station(StationStatus.YEOKSAM));
        StationRepository.addStation(new Station(StationStatus.NAMBU_TERMINAL));
        StationRepository.addStation(new Station(StationStatus.YANGJE));
        StationRepository.addStation(new Station(StationStatus.MAEBONG));
        StationRepository.addStation(new Station(StationStatus.YANGJE_FOREST));
    }

    public List<Station> findStations(final List<String> inputSubwayStations) {
        return inputSubwayStations.stream()
                .map(StationRepository::findStation)
                .collect(Collectors.toList());
    }
}
