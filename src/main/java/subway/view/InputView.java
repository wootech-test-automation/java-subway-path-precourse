package subway.view;

import camp.nextstep.edu.missionutils.Console;
import subway.domain.type.Station;
import subway.launcher.keyword.MainFeatureKeyword;
import subway.launcher.keyword.PathFeatureKeyword;

public class InputView extends View {
    private static final String REQUEST_MAIN_FEATURE = "## 메인 화면\n"
            + "1. 경로 조회\n"
            + "Q. 종료\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.";

    private static final String REQUEST_PATH_FEATURE = "## 경로 기준\n"
            + "1. 최단 거리\n"
            + "2. 최소 시간\n"
            + "B. 돌아가기\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.";

    private static final String REQUEST_SOURCE = "## 출발역을 입력하세요.";
    private static final String REQUEST_TARGET = "## 도착역을 입력하세요.";

    public MainFeatureKeyword inputMainFeature() {
        print(REQUEST_MAIN_FEATURE);
        String line = Console.readLine();
        printEmptyLine();
        return MainFeatureKeyword.nameOf(line);
    }

    public PathFeatureKeyword inputPathFeature() {
        print(REQUEST_PATH_FEATURE);
        String line = Console.readLine();
        printEmptyLine();
        return PathFeatureKeyword.nameOf(line);
    }

    public Station inputSourceStation() {
        print(REQUEST_SOURCE);
        String line = Console.readLine();
        printEmptyLine();
        return new Station(line);
    }

    public Station inputTargetStation() {
        print(REQUEST_TARGET);
        String line = Console.readLine();
        printEmptyLine();
        return new Station(line);
    }
}
