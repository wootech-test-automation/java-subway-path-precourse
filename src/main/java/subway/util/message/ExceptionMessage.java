package subway.util.message;

public enum ExceptionMessage {

    INVALID_MAIN_OPTION("올바른 메인 옵션을 입력해 주세요."),
    INVALID_ROUTE_OPTION("올바른 경로 조회 옵션을 입력해 주세요."),
    NO_SUCH_STATION("해당 이름의 역이 존재하지 않습니다."),
    NO_SUCH_LINE("해당 이름의 노선이 존재하지 않습니다."),
    INVALID_SAME_DEPARTURE_AND_ARRIVAL_STATION("출발역과 도착역이 동일합니다."),
    PROBLEM_OCCURRED("프로그램 실행 중 문제가 발생했습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}