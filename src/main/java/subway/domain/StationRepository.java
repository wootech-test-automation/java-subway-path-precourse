package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.message.ErrorMessage;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }


    public static Station findStation(final String stationName) {
        return stations.stream()
                .filter(station -> station.contains(stationName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_STATION_ERROR));
    }
}
