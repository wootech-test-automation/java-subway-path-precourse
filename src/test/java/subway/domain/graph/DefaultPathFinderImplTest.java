package subway.domain.graph;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;
import subway.domain.InitRepositoryHelper;
import subway.domain.type.PathResult;
import subway.domain.type.Section;
import subway.domain.type.Station;

class DefaultPathFinderImplTest {

    private final GraphMaker graphMaker = new DefaultGraphMakerImpl();

    @Test
    void operationTest() {
        // given
        InitRepositoryHelper.init();
        WeightedMultigraph<Station, Section> graph = graphMaker.make("distance");
        PathFinder pathFinder = new DefaultPathFinderImpl(graph);

        // when
        PathResult pathResult = pathFinder.getPathResult(new Station("교대역"), new Station("양재역"));

    }

    @Test
    void shouldThrowIllegalVertexInput() {
        // given
        InitRepositoryHelper.init();
        WeightedMultigraph<Station, Section> graph = graphMaker.make("distance");

        PathFinder pathFinder = new DefaultPathFinderImpl(graph);

        // when
        assertThatThrownBy(() -> {
            pathFinder.getPathResult(new Station("교식역"), new Station("교당역"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowSameSourceAndTarget() {
        // given
        InitRepositoryHelper.init();
        WeightedMultigraph<Station, Section> graph = graphMaker.make("distance");

        PathFinder pathFinder = new DefaultPathFinderImpl(graph);

        // when
        assertThatThrownBy(() -> {
            pathFinder.getPathResult(new Station("교대역"), new Station("교대역"));
        }).isInstanceOf(IllegalArgumentException.class);

    }
}