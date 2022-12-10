package subway.controller;

import java.util.List;
import subway.service.SubwayPathService;
import subway.utils.InputValidator;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayPathController {
    public static final String SEARCH_PATH = "1";
    public static final String SHORTEST_PATH = "1";
    public static final String MINIMUM_TIME = "2";
    public static final String QUIT = "Q";
    public static final String BACK = "B";
    private final SubwayPathService subwayPathService = new SubwayPathService();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        initializeSubwayPath();
        requestMenu(inputView.inputFeature());
    }

    private void requestMenu(final String userInput) {
        try {
            determineMenu(InputValidator.validateMenuSelect(userInput));
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            run();
        }
    }

    private void determineMenu(final String validatedInput) {
        if (validatedInput.equals(SEARCH_PATH)) {
            try {
                determinePathStandard(InputValidator.validatePathStandard(inputView.inputPathStandard()));
            } catch (IllegalArgumentException exception) {
                outputView.printMessage(exception.getMessage());
                determineMenu(validatedInput);
            }
        }
    }

    private void determinePathStandard(final String validatedInput) {
        if (validatedInput.equals(SHORTEST_PATH)) {
            requestShortestPath();
        }
        if (validatedInput.equals(MINIMUM_TIME)) {
            requestMinimumTime();
        }
        run();
    }

    private void requestMinimumTime() {
        List<Object> shortestPathResult = subwayPathService.createMinimumTimeResult(inputView.inputSubwayStation());
        outputView.printResults(shortestPathResult);
    }

    private void requestShortestPath() {
        List<Object> shortestPathResult = subwayPathService.createShortestPathResult(inputView.inputSubwayStation());
        outputView.printResults(shortestPathResult);
    }

    private void initializeSubwayPath() {
        subwayPathService.initializeSubwayPath();
    }
}
