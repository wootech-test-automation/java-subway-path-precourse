package subway.domain.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.station.Station;
import subway.domain.weight.WeightDivision;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    static {
        sections.add(new Section(new Station("교대역"), new Station("강남역"), new WeightDivision("2/3")));
        sections.add(new Section(new Station("강남역"), new Station("역삼역"), new WeightDivision("2/3")));

        sections.add(new Section(new Station("교대역"), new Station("남부터미널역"), new WeightDivision("3/2")));
        sections.add(new Section(new Station("남부터미널역"), new Station("양재역"), new WeightDivision("6/5")));
        sections.add(new Section(new Station("양재역"), new Station("매봉역"), new WeightDivision("1/1")));

        sections.add(new Section(new Station("강남역"), new Station("양재역"), new WeightDivision("2/8")));
        sections.add(new Section(new Station("양재역"), new Station("양재시민의숲역"), new WeightDivision("10/3")));
    }

    public static List<Section> sections(){
        return Collections.unmodifiableList(sections);
    }


}
