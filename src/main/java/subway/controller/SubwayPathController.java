package subway.controller;

import subway.service.LineService;
import subway.service.StationService;
import subway.utils.ShortestDistancePathService;
import subway.utils.ShortestTimePathService;
import subway.view.InputVIew;
import subway.view.OutputView;

public class SubwayPathController {
    private final LineService lineService = new LineService();
    private final StationService stationService = new StationService();
    private final OutputView outputView = new OutputView();
    private final InputVIew inputVIew = new InputVIew();

    public void run() {
        initializeSubwayPath();
        outputView.printMainMenu();
        inputVIew.inputFeature();
    }

    private void initializeSubwayPath() {
        ShortestDistancePathService.initializePath();
        ShortestTimePathService.initializePath();
        lineService.initializeLine();
        stationService.initializeStation();
    }
}
