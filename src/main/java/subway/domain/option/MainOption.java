package subway.domain.option;

import java.util.Arrays;
import subway.util.message.ExceptionMessage;

public enum MainOption {

    ROUTE_SEARCH("1"), QUIT("Q");

    private final String command;

    MainOption(String command) {
        this.command = command;
    }

    public static MainOption from(String command) {
        return Arrays.stream(MainOption.values())
                .filter(element -> element.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_MAIN_OPTION.getMessage()));
    }
}
