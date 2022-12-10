package subway.view;

import java.util.List;
import subway.domain.ResultDto;
import subway.domain.Station;

public class OutputView extends IoPrinter{
    public void printResult(List<Station> result) {
        this.println(result);
    }

    public void printResult(ResultDto result) {
        this.printTitle("조회 결과");
        this.info("---");
        this.info(String.format("총 거리: %dkm", result.getDistanceSum()));
        this.info(String.format("총 소요 시간: %d분", result.getTimeSum()));
        this.info("---");
        this.info(result.getStationName());
    }

    public void printError(String message) {
        this.println(String.format("[ERROR] %s",message));
    }
}
