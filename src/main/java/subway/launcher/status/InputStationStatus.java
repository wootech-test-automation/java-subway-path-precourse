package subway.launcher.status;

import subway.domain.type.PathResult;
import subway.domain.type.Station;
import subway.launcher.SubwayLauncher;
import subway.launcher.keyword.PathFeatureKeyword;

public class InputStationStatus extends AbstractRunnableSubwayStatus {

    private final PathFeatureKeyword pathFeatureKeyword;

    public InputStationStatus(SubwayLauncher context, PathFeatureKeyword pathFeatureKeyword) {
        super(context);
        this.pathFeatureKeyword = pathFeatureKeyword;
    }

    @Override
    public SubwayStatus process() {
        Station sourceStation = inputView.inputSourceStation();
        Station targetStation = inputView.inputTargetStation();
        PathResult pathResult = callGameStatus(sourceStation, targetStation);
        outputView.showPathResult(pathResult);
        return new MainFeatureStatus(context);
    }

    private PathResult callGameStatus(Station source, Station target) {
        if (pathFeatureKeyword.equals(PathFeatureKeyword.DISTANCE)) {
            return subwayGame.getShortestPathByDistance(source, target);
        }
        // time
        return subwayGame.getShortestPathByTime(source, target);
    }
}
