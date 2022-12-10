package subway.service;

import java.util.List;
import subway.domain.enums.StationStatus;
import subway.message.ErrorMessage;

public class SubwayPathService {
    private final LineService lineService = new LineService();
    private final StationService stationService = new StationService();

    public void initializeSubwayPath() {
        lineService.initializeLine();
        stationService.initializeStation();
    }

    public void createShortestPathResult(final List<String> inputSubwayStations) {
        validateInputStations(inputSubwayStations);
    }

    private void validateInputStations(final List<String> inputSubwayStations) {
        StationStatus.containsAll(inputSubwayStations);
        if (inputSubwayStations.get(0).equals(inputSubwayStations.get(1))) {
            throw new IllegalArgumentException(ErrorMessage.SAME_STATION_ERROR);
        }
    }
}
