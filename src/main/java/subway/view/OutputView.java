package subway.view;

public class OutputView {

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
    }

}