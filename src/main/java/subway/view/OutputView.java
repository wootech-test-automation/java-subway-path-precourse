package subway.view;

import subway.domain.type.PathResult;

public class OutputView extends View {

    private static final String RESULT = "## 조회 결과";
    private static final String INFO = "[INFO]";

    public void showPathResult(PathResult pathResult) {
        print(RESULT);
        print(String.format("%s ---", INFO));
        print(String.format("%s 총 거리: %dkm", INFO, pathResult.getTotalDistance()));
        print(String.format("%s 총 소요 시간: %d분", INFO, pathResult.getTotalTime()));
        print(String.format("%s ---", INFO));
        printShortestPath(pathResult);
        printEmptyLine();
    }

    public void printError(String message) {
        super.printError(message);
    }

    private void printShortestPath(PathResult pathResult) {
        pathResult.getShortestPath().forEach(station -> print(String.format("%s %s", INFO, station)));
    }
}
