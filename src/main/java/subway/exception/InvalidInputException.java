package subway.exception;

public class InvalidInputException extends IllegalArgumentException {
    private static final String ERROR_FORMAT = "%s [input = %s]";

    public InvalidInputException(String message, String input) {
        super(String.format(ERROR_FORMAT, message, input));
    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException() {
        super("유요하지 않는 입력입니다.");
    }
}
