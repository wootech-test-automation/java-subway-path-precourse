package subway.controller;

import java.util.Scanner;
import subway.domain.SubwaySystem;
import subway.domain.type.MainMenu;
import subway.domain.type.RouteMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    private final InputView inputView;
    private final SubwaySystem subwaySystem = new SubwaySystem();

    public SubwayController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void system() {
        while (mainDisplay() != MainMenu.QUIT) {
            routeDisplay();
        }
    }

    private MainMenu mainDisplay() {
        OutputView.printMainMenu();
        return inputView.readMainMenu();
    }

    private void routeDisplay() {
        // 목표 경로 입력
        OutputView.printRouteMenu();
        RouteMenu menu = inputView.readRouteMenu();
        // 경로 탐색 진행
        if (menu.isShortestCommand()) {
            subwaySystem.shortestRoute();
        }
        if (menu.isFastestCommand()) {
            subwaySystem.fastestRoute();
        }
    }
}
