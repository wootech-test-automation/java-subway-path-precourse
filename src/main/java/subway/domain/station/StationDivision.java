package subway.domain.station;

import java.util.Objects;
import subway.exception.InvalidInputException;

public class StationDivision {
    
    private final Station upStation;
    private final Station terminalStation;

    public StationDivision(Station upStation, Station terminalStation) {
        if (upStation.equals(terminalStation)) {
            throw new InvalidInputException("두 역이 중복됩니다.");
        }
        this.upStation = upStation;
        this.terminalStation = terminalStation;
    }

    public Station getUpStation() {
        return upStation;
    }

    public Station getTerminalStation() {
        return terminalStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StationDivision that = (StationDivision) o;
        return Objects.equals(upStation, that.upStation) && Objects.equals(terminalStation,
                that.terminalStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upStation, terminalStation);
    }
}
