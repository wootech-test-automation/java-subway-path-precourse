package subway.view;

import camp.nextstep.edu.missionutils.Console;
import subway.message.InputMessage;
import subway.message.OutputMessage;

public class InputVIew {

    public String inputFeature() {
        System.out.println(OutputMessage.MAIN_MENU_MESSAGE);
        System.out.println(OutputMessage.SEARCH_PATH_MESSAGE);
        System.out.println(OutputMessage.END_PATH_MESSAGE);
        return inputSelection();
    }

    private String inputSelection() {
        System.out.println();
        System.out.println(InputMessage.FEATURE_CHOICE_MESSAGE);
        return readLine();
    }

    public String inputPathStandard() {
        System.out.println();
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
        return inputSelection();
    }

    private String readLine() {
        return Console.readLine();
    }

}
