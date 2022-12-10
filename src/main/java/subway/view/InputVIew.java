package subway.view;

import camp.nextstep.edu.missionutils.Console;
import subway.message.InputMessage;

public class InputVIew {

    public String inputFeature() {
        System.out.println(InputMessage.FEATURE_CHOICE_MESSAGE);
        return readLine();
    }

    private String readLine() {
        return Console.readLine();
    }
}
