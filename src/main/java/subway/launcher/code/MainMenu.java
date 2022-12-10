package subway.launcher.code;

import java.util.Arrays;
import java.util.stream.Collectors;
import subway.exception.InvalidInputException;
import subway.launcher.status.BasicStatus;
import subway.launcher.status.QuiteStatus;
import subway.launcher.status.SelectChildMenuStatus;

public enum MainMenu {
    MENU_1("1","경로 조회", new SelectChildMenuStatus()),
    MENU_Q("Q","종료", new QuiteStatus());

    private final String command;
    private final String message;
    private final BasicStatus nextStatus;

    MainMenu(String command, String message, BasicStatus nextStatus) {
        this.command = command;
        this.message = message;
        this.nextStatus = nextStatus;
    }

    public static MainMenu from(final String input){
        return Arrays.stream(values())
                .filter(mainMenu -> mainMenu.command.equals(input.trim()))
                .findAny()
                .orElseThrow(() -> new InvalidInputException("잘못된 입력입니다",input));
    }

    public static String message(){
        return Arrays.stream(values())
                .map(mainMenu -> String.format("%s. %s",mainMenu.command, mainMenu.message))
                .collect(Collectors.joining("\n"));
    }

    public BasicStatus getNextStatus(){
        return nextStatus;
    }
}
