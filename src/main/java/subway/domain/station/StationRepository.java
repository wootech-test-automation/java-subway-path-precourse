package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.exception.InvalidInputException;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    static {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("매봉역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("테스트"));
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static Station findByName(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .orElseThrow(() ->new IllegalStateException("잘못된 이름입니다."));
    }

    public static void existsByStation(Station upStation) {
        stations.stream()
                .filter(station -> station.equals(upStation))
                .findAny()
                .orElseThrow(()-> new InvalidInputException("존재하지 않는 역입니다."));

    }
}
