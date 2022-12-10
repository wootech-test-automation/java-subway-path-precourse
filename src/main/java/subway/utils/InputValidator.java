package subway.utils;

import subway.message.ErrorMessage;

public class InputValidator {
    public static final String SEARCH_PATH = "1";
    public static final String SHORTEST_PATH = "1";
    public static final String MINIMUM_TIME = "2";
    public static final String QUIT = "Q";
    public static final String BACK = "B";


    private InputValidator() {
    }

    public static String validateMenuSelect(String userInput) {
        if (!userInput.equals(SEARCH_PATH) && !userInput.equals(QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.MENU_INPUT_ERROR);
        }
        return userInput;
    }

    public static String validatePathStandard(final String userInput) {
        if (!userInput.equals(SHORTEST_PATH) && !userInput.equals(MINIMUM_TIME) && !userInput.equals(BACK)) {
            throw new IllegalArgumentException(ErrorMessage.STANDARD_INPUT_ERROR);
        }
        return userInput;
    }
}
