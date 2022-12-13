package subway.view;

import java.util.Scanner;
import subway.domain.type.MainMenu;
import subway.domain.type.RouteMenu;

public class InputView {
    private final Scanner scanner;
    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private String readLine() {
        return scanner.nextLine();
    }

    public MainMenu readMainMenu() {
        String input = readLine();
        return MainMenu.fromCommand(input);
    }

    public RouteMenu readRouteMenu() {
        String input = readLine();
        return RouteMenu.fromCommand(input);
    }

    public String readStationName() {
        String input = readLine();
        return input;
    }
}
