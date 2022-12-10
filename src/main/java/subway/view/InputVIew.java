package subway.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import subway.message.InputMessage;

public class InputVIew {

    public static final String START_STATION_INPUT_MESSAGE = "## 출발역을 입력하세요.";
    public static final String END_STATION_INPUT_MESSAGE = "## 도착역을 입력하세요.";

    public String inputFeature() {
        System.out.println(InputMessage.MAIN_MENU_MESSAGE);
        System.out.println(InputMessage.SEARCH_PATH_MESSAGE);
        System.out.println(InputMessage.END_PATH_MESSAGE);
        return inputSelection();
    }

    private String inputSelection() {
        System.out.println();
        System.out.println(InputMessage.FEATURE_CHOICE_MESSAGE);
        return readLine();
    }

    public String inputPathStandard() {
        System.out.println();
        System.out.println(InputMessage.PATH_STANDARD);
        System.out.println(InputMessage.SHORTEST_PATH_MESSAGE);
        System.out.println(InputMessage.MINIMUM_TIME_MESSAGE);
        System.out.println(InputMessage.BACK_MESSAGE);
        return inputSelection();
    }

    public List<String> inputSubwayStation() {
        List<String> userInputs = new ArrayList<>();
        System.out.println();
        System.out.println(InputMessage.START_STATION_INPUT_MESSAGE);
        userInputs.add(readLine());
        System.out.println();
        System.out.println(InputMessage.END_STATION_INPUT_MESSAGE);
        userInputs.add(readLine());
        return userInputs;
    }

    private String readLine() {
        return Console.readLine();
    }

}
