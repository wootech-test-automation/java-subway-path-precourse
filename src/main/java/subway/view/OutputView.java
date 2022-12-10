package subway.view;

import java.util.List;

public class OutputView {

    public static final String DIVIDER = "---";

    private enum ConsoleMessage {
        OUTPUT_MAIN_SCREEN("## 메인 화면\n"
                + "1. 경로 조회\n"
                + "Q. 종료"),
        OUTPUT_ROUTE_OPTION("## 경로 기준\n"
                + "1. 최단 거리\n"
                + "2. 최소 시간\n"
                + "B. 돌아가기"),
        OUTPUT_QUERY_RESULT("## 조회 결과"),
        OUTPUT_QUERY_RESULT_FORM("[INFO] %s");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public void printMainScreen() {
        System.out.println(ConsoleMessage.OUTPUT_MAIN_SCREEN.message);
        System.out.println();
    }

    public void printRouteOption() {
        System.out.println(ConsoleMessage.OUTPUT_ROUTE_OPTION.message);
        System.out.println();
    }

    public void printQueryResult(int weight, List<String> result) {
        System.out.println(ConsoleMessage.OUTPUT_QUERY_RESULT.message);
        printFormattedQueryResult(DIVIDER);
        printFormattedQueryResult(String.format("총 거리: %dkm", weight));
        printFormattedQueryResult(DIVIDER);
        for (String station : result) {
            printFormattedQueryResult(station);
        }
        System.out.println();
    }

    private void printFormattedQueryResult(String string) {
        System.out.println(String.format("[INFO] %s", string));
    }

}