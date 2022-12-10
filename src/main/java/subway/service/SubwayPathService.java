package subway.service;

import java.util.List;
import subway.domain.Station;
import subway.message.ErrorMessage;
import subway.utils.MinimumTimePath;
import subway.utils.ShortestDistancePath;

public class SubwayPathService {
    private final LineService lineService = new LineService();
    private final StationService stationService = new StationService();

    public void initializeSubwayPath() {
        lineService.initializeLine();
        stationService.initializeStation();
        ShortestDistancePath.initializePath();
        MinimumTimePath.initializePath();
    }

    public List<Object> createShortestPathResult(final List<String> inputSubwayStations) {
        List<Station> stations = stationService.findStations(inputSubwayStations);
        validateInputStations(stations);
        return ShortestDistancePath.createResultList(stations);
    }

    private void validateInputStations(final List<Station> inputSubwayStations) {
        if (inputSubwayStations.get(0).equals(inputSubwayStations.get(1))) {
            throw new IllegalArgumentException(ErrorMessage.SAME_STATION_ERROR);
        }
    }
}
