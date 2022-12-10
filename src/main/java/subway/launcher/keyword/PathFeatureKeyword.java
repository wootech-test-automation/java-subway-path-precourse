package subway.launcher.keyword;

import java.util.Arrays;

public enum PathFeatureKeyword {
    DISTANCE("1"),
    TIME("2"),
    BACK("B");

    private static final String ERROR_INPUT_MESSAGE = "1,2,B만 입력해주세요.";
    private final String keyword;

    PathFeatureKeyword(String keyword) {
        this.keyword = keyword;
    }

    public static PathFeatureKeyword nameOf(String keyword) {
        return Arrays.stream(PathFeatureKeyword.values())
                .filter(pathFeatureKeyword -> keyword.equals(pathFeatureKeyword.keyword))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INPUT_MESSAGE));
    }
}
