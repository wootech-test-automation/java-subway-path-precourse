package subway.domain.option;

import java.util.Arrays;
import subway.util.message.ExceptionMessage;

public enum RouteOption {

    SHORTEST_DISTANCE("1"),
    SHORTEST_TIME("2"),
    BACK("B");

    private final String command;

    RouteOption(String command) {
        this.command = command;
    }

    public static RouteOption from(String command) {
        return Arrays.stream(RouteOption.values())
                .filter(element -> element.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_ROUTE_OPTION.getMessage()));
    }
}
