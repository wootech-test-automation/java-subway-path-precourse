package subway.domain.enums;

import java.util.Arrays;
import java.util.List;
import subway.message.ErrorMessage;

public enum StationStatus {
    KYODAE("교대역"),
    GANGNAM("강남역"),
    YEOKSAM("역삼역"),
    NAMBU_TERMINAL("남부터미널역"),
    YANGJE("양재역"),
    MAEBONG("매봉역"),
    YANGJE_FOREST("양재시민의숲역");

    private final String name;

    StationStatus(final String name) {
        this.name = name;
    }

    public static void containsAll(final List<String> inputSubwayStation) {
        inputSubwayStation.forEach(StationStatus::contains);
    }

    private static void contains(final String station) {
        Arrays.stream(StationStatus.values())
                .filter(stationStatus -> stationStatus.name.equals(station))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_STATION_ERROR));
    }

    public String getName() {
        return this.name;
    }
}
