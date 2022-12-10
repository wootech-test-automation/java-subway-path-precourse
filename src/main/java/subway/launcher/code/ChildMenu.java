package subway.launcher.code;

import java.util.Arrays;
import java.util.stream.Collectors;
import subway.exception.InvalidInputException;
import subway.launcher.status.BasicStatus;
import subway.launcher.status.CalculateShortestDistance;
import subway.launcher.status.CalculateShortestTime;
import subway.launcher.status.InputStationStatus;
import subway.launcher.status.SelectMainMenuStatus;

public enum ChildMenu {
      MENU_1("1","최단 거리", new InputStationStatus(new CalculateShortestDistance())),
      MENU_2("2","최소 시간", new InputStationStatus(new CalculateShortestTime())),
      MENU_B("B","돌아가기", new SelectMainMenuStatus());

    private final String command;
    private final String message;
    private final BasicStatus nextStatus;

    ChildMenu(String command, String message, BasicStatus nextStatus) {
        this.command = command;
        this.message = message;
        this.nextStatus = nextStatus;
    }

    public static ChildMenu from(final String input){
        return Arrays.stream(values())
                .filter(menu  -> menu.command.equals(input.trim()))
                .findAny()
                .orElseThrow(() -> new InvalidInputException("잘못된 입력입니다",input));
    }

    public static String message(){
        return Arrays.stream(values())
                .map(menu -> String.format("%s. %s",menu.command, menu.message))
                .collect(Collectors.joining("\n"));
    }

    public BasicStatus getNextStatus(){
        return nextStatus;
    }
}
