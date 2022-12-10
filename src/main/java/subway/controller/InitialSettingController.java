package subway.controller;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitialSettingController {
    public static void initialize() {
        initializeStations();
        initializeLines();
    }

    private static void initializeStations() {
        List<String> stations = new ArrayList<>(List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
        stations.stream().map(Station::new).forEach(StationRepository::addStation);
    }

    private static void initializeLines() {
        List<String> lines = new ArrayList<>(List.of("2호선", "3호선", "신분당선"));
        lines.stream().map(Line::new).forEach(LineRepository::addLine);
    }
}
