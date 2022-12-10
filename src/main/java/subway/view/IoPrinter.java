package subway.view;

import java.util.List;
import java.util.stream.Collectors;

public class IoPrinter {
    private static final String INFO_FORMAT = "[INFO] %s";
    private static final String ERROR_FORMAT = "[ERROR] %s";
    private static final String TITLE_FORMAT = "## %s";

    protected void println(){
        this.println("");
    }
    protected void println(final Object message){
        System.out.println(message);
    }

    protected void printTitle(final Object titleName){
        this.println(String.format(TITLE_FORMAT, titleName));
    }

    protected void info(final List<String> message){
        this.println(message.stream().map(s -> String.format(INFO_FORMAT,s)).collect(Collectors.joining("\n")));
    }
    protected void info(final Object message) {
        this.println(String.format(INFO_FORMAT, message));
    }

    protected void error(final Object message){
        this.println(String.format(ERROR_FORMAT, message));
    }
}
