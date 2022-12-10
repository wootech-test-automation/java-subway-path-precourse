package subway.view;

public class View {

    private static final String ERROR = "[ERROR]";

    protected void print(String message) {
        System.out.println(message);
    }

    protected void printEmptyLine() {
        System.out.println();
    }

    protected void printError(String message) {
        System.out.println(ERROR + " " + message);
    }
}
