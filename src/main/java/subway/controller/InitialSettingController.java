package subway.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class InitialSettingController {

    public static final List<String> STATIONS = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    public static final List<String> LINES = List.of("2호선", "3호선", "신분당선");


    public static void initialize() {
        initializeStations();
        initializeLines();
        connectStationsWithLines();
        connectLinesWithStations();
    }

    private static void initializeStations() {
        List<String> stations = new ArrayList<>(STATIONS);
        stations.stream().map(Station::new).forEach(StationRepository::addStation);
    }

    private static void initializeLines() {
        List<String> lines = new ArrayList<>(LINES);
        lines.stream().map(Line::new).forEach(LineRepository::addLine);
    }

    private static void connectStationsWithLines() {
        Map<String, List<String>> stationsAndLines = setStationsAndLinesMap();
        stationsAndLines.keySet().stream()
                .map(StationRepository::findStationByName)
                .forEach(station -> station.addLines(stationsAndLines.get(station.getName())));
    }

    private static Map<String, List<String>> setStationsAndLinesMap() {
        Map<String, List<String>> stationsAndLines = new HashMap<>();
        stationsAndLines.put("교대역", List.of("2호선", "3호선"));
        stationsAndLines.put("강남역", List.of("2호선", "신분당선"));
        stationsAndLines.put("역삼역", List.of("2호선"));
        stationsAndLines.put("남부터미널역", List.of("3호선"));
        stationsAndLines.put("양재역", List.of("3호선", "신분당선"));
        stationsAndLines.put("매봉역", List.of("3호선"));
        stationsAndLines.put("양재시민의숲역", List.of("신분당선"));
        return stationsAndLines;
    }

    private static void connectLinesWithStations() {
        Map<String, List<String>> linesAndStations = setLinesAndStationsMap();
        linesAndStations.keySet().stream()
                .map(LineRepository::findLineByName)
                .forEach(line -> line.addStations(linesAndStations.get(line.getName())));
    }

    private static Map<String, List<String>> setLinesAndStationsMap() {
        Map<String, List<String>> linesAndStations = new HashMap<>();
        linesAndStations.put("2호선", List.of("교대역", "강남역", "역삼역"));
        linesAndStations.put("3호선", List.of("교대역 ", "남부터미널역", "양재역", "매봉역"));
        linesAndStations.put("신분당선", List.of("강남역", "양재역", "양재시민의숲역"));
        return linesAndStations;
    }
}
