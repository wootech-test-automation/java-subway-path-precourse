package subway.controller;

import java.util.Scanner;
import subway.domain.SubwaySystem;
import subway.view.InputView;

public class SubwayController {
    private final InputView inputView;
    private final SubwaySystem scanner = new SubwaySystem();

    public SubwayController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void system() {

    }

    private void mainDisplay() {

    }

    private void routeDisplay() {

    }
}
