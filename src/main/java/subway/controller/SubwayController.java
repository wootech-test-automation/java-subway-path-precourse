package subway.controller;

import java.util.List;
import java.util.Scanner;
import subway.domain.SubwaySystem;
import subway.domain.type.MainMenu;
import subway.domain.type.PathFindResult;
import subway.domain.type.RouteMenu;
import subway.domain.type.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    private final InputView inputView;
    private final SubwaySystem subwaySystem = new SubwaySystem();

    public SubwayController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void system() {
        try {
            while (mainDisplay() != MainMenu.QUIT) {
                routeDisplay();
            }
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
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
        PathFindResult pathFindResult;
        if (menu.isShortestCommand()) {
            pathFindResult = subwaySystem.shortestRoute(readStartStationName(), readDestinationStationName());
            OutputView.printResult(pathFindResult);
        }
        if (menu.isFastestCommand()) {
            pathFindResult = subwaySystem.fastestRoute(readStartStationName(), readDestinationStationName());
            OutputView.printResult(pathFindResult);
        }
    }

    private String readStartStationName() {
        OutputView.printInputStationStart();
        return inputView.readStationName();
    }
    private String readDestinationStationName() {
        OutputView.printInputStationEnd();
        return inputView.readStationName();
    }
}
