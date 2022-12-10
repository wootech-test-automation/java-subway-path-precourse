package subway.domain.enums;

import java.util.Arrays;
import java.util.List;
import subway.message.ErrorMessage;

public enum LineStatus {
    LINE_TWO("2호선", List.of(
            StationStatus.KYODAE,
            StationStatus.GANGNAM,
            StationStatus.YEOKSAM)),
    LINE_THREE("3호선", List.of(
            StationStatus.KYODAE,
            StationStatus.NAMBU_TERMINAL,
            StationStatus.YANGJE,
            StationStatus.MAEBONG)),
    LINE_NEW_BUNDANG("신분당선", List.of(
            StationStatus.GANGNAM,
            StationStatus.YANGJE,
            StationStatus.YANGJE_FOREST
    ));

    private final String name;
    private final List<StationStatus> stations;

    LineStatus(final String name, final List<StationStatus> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return this.name;
    }
}
