package subway.domain.type;

import java.util.Arrays;

public enum RouteMenu {
    SHORTEST("1", "최단 거리"),
    FASTEST("2", "최소 시간"),
    BACK("B", "돌아가기");

    private final String command;
    private final String name;

    RouteMenu(String command, String name) {
        this.command = command;
        this.name = name;
    }

    public static RouteMenu fromCommand(String command) {
        return Arrays.stream(RouteMenu.values())
                .filter(menu -> RouteMenu.isSameCommand(menu.getCommand(), command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("인자와 일치하는 경로조회 메뉴 항목이 없습니다. " + command));
    }

    public static boolean isSameCommand(String command, String command2) {
        return command.equals(command2);
    }

    public boolean isShortestCommand() {
        return this == SHORTEST;
    }

    public boolean isFastestCommand() {
        return this == FASTEST;
    }

    private String getCommand() {
        return command;
    }
}
