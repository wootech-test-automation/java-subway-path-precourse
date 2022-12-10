package subway.domain;

import subway.domain.repository.LineRepository;
import subway.domain.repository.SectionRepository;
import subway.domain.repository.StationRepository;
import subway.domain.type.Line;
import subway.domain.type.Section;
import subway.domain.type.Station;

public class InitRepositoryHelper {

    public static void initStation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
        StationRepository.addStation(new Station("역삼역"));
    }

    public static void initLine2() {
        Line line1 = Line.of("2호선", "교대역", "강남역");
        Line line2 = Line.of("2호선", "강남역", "역삼역");
        LineRepository.addLine(line1);
        LineRepository.addLine(line2);
        SectionRepository.addSection(Section.of(line1, 2, 3));
        SectionRepository.addSection(Section.of(line2, 2, 3));
    }

    public static void initLine3() {
        Line line3 = Line.of("3호선", "교대역", "남부터미널역");
        Line line4 = Line.of("3호선", "남부터미널역", "양재역");
        Line line5 = Line.of("3호선", "양재역", "매봉역");

        LineRepository.addLine(line3);
        LineRepository.addLine(line4);
        LineRepository.addLine(line5);
        SectionRepository.addSection(Section.of(line3, 3, 2));
        SectionRepository.addSection(Section.of(line4, 6, 5));
        SectionRepository.addSection(Section.of(line5, 1, 1));
    }

    public static void initLineNew() {
        Line line6 = Line.of("신분당선", "강남역", "양재역");
        Line line7 = Line.of("신분당선", "양재역", "양재시민의숲역");

        LineRepository.addLine(line6);
        LineRepository.addLine(line7);
        SectionRepository.addSection(Section.of(line6, 2, 8));
        SectionRepository.addSection(Section.of(line7, 10, 3));
    }

    public static void init() {
        initStation();
        initLine2();
        initLine3();
        initLineNew();
    }
}
