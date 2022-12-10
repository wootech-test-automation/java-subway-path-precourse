package subway.domain.graph;

import subway.domain.type.PathResult;
import subway.domain.type.Station;

public interface PathFinder {

    PathResult getPathResult(Station source, Station target);
}
