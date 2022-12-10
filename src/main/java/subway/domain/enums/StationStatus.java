package subway.domain.enums;

import java.util.Arrays;
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

    public String getName() {
        return this.name;
    }
}
