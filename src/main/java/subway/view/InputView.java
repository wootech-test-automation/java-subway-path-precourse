package subway.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private String readLine() {
        return scanner.nextLine();
    }

    public String readMainMenu() {
        String input = readLine();
        return input;
    }

    public String readRouteMenu() {
        String input = readLine();
        return input;
    }

    public String readStationName() {
        String input = readLine();
        return input;
    }
}
