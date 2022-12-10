package subway.view.keyword;

import java.util.Arrays;

public enum MainFeatureKeyword {
    SEARCH("1"),
    QUIT("Q");

    private static final String ERROR_INPUT_MESSAGE = "1, Q만 입력해주세요.";
    private final String keyword;

    MainFeatureKeyword(String keyword) {
        this.keyword = keyword;
    }

    public static MainFeatureKeyword nameOf(String keyword) {
        return Arrays.stream(MainFeatureKeyword.values())
                .filter(mainFeatureKeyword -> keyword.equals(mainFeatureKeyword.keyword))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INPUT_MESSAGE));
    }
}
