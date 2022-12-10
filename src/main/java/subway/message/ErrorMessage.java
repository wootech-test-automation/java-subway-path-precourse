package subway.message;

public class ErrorMessage {
    public static final String NO_LINE_ERROR = "[ERROR] 존재하지 않는 노선 입니다.";
    public static final String NO_STATION_ERROR = "[ERROR] 존재하지 않는 역입니다.";

    public static final String MENU_INPUT_ERROR = "[ERROR] 1 또는 Q만 입력할 수 있습니다.";
    public static final String STANDARD_INPUT_ERROR = "[ERROR] 1, 2, B만 입력할 수 있습니다.";

    private ErrorMessage() {
    }
}
