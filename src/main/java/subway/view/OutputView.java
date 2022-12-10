package subway.view;

import java.util.List;

public class OutputView {
    public void printMessage(final String message) {
        System.out.println(message);
    }

    public void printResults(final List<Object> shortestPathResult) {
        System.out.println();
        System.out.println("## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.printf("[INFO] 총 거리: %dkm\n", (int) shortestPathResult.get(0));
        System.out.printf("[INFO] 총 소요시간: %d분\n", (int) shortestPathResult.get(1));
        System.out.println("[INFO] ---");
        System.out.println(createResultStationsMessage((List<String>) shortestPathResult.get(2)));
    }

    private String createResultStationsMessage(final List<String> stations) {
        StringBuilder messages = new StringBuilder();
        stations.stream()
                .forEach(station -> messages.append("[INFO] ")
                        .append(station)
                        .append("\n"));
        return messages.toString();
    }
}
