package subway.domain.type;

import java.util.Arrays;

public enum MainMenu {
    ROUTE_SELECT("1", "경로 조회"),
    QUIT("Q", "종료");

    private final String command;
    private final String name;

    MainMenu(String command, String name) {
        this.command = command;
        this.name = name;
    }

    public static MainMenu fromCommand(String command) {
        return Arrays.stream(MainMenu.values())
                .filter(menu -> MainMenu.isSameCommand(menu.getCommand(), command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("인자와 일치하는 메인메뉴 항목이 없습니다. " + command));
    }

    public static boolean isSameCommand(String command, String command2) {
        return command.equals(command2);
    }

    private String getCommand() {
        return command;
    }
}
