package subway.view;

import subway.message.OutputMessage;

public class OutputView {

    public void printMainMenu() {
        System.out.println(OutputMessage.MAIN_MENU_MESSAGE);
        System.out.println(OutputMessage.SEARCH_PATH_MESSAGE);
        System.out.println(OutputMessage.END_PATH_MESSAGE);
        System.out.println();
    }
}
