package subway.view;

import camp.nextstep.edu.missionutils.Console;
import subway.domain.Station;
import subway.domain.option.MainOption;
import subway.domain.option.RouteOption;
import subway.util.Util;

public class InputView {

    private enum ConsoleMessage {
        INPUT_MAIN_OPTION("## 원하는 기능을 선택하세요."),
        INPUT_ROUTE_OPTION("## 원하는 기능을 선택하세요."),
        INPUT_DEPARTURE_STATION("## 출발역을 입력하세요."),
        INPUT_ARRIVAL_STATION("## 도착역을 입력하세요.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public MainOption readMainOption() {
        System.out.println(ConsoleMessage.INPUT_MAIN_OPTION.message);
        return MainOption.from(Util.removeSpace(Console.readLine()));
    }

    public RouteOption readRouteOption() {
        System.out.println(ConsoleMessage.INPUT_ROUTE_OPTION.message);
        return RouteOption.from(Util.removeSpace(Console.readLine()));
    }

    public Station readDepartureStation(){
        System.out.println(ConsoleMessage.INPUT_DEPARTURE_STATION.message);
    }
}