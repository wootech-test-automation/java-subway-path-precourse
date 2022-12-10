package subway.launcher.status;

import subway.launcher.SubwayLauncher;
import subway.view.keyword.PathFeatureKeyword;

public class PathFeatureStatus extends AbstractRunnableSubwayStatus {

    public PathFeatureStatus(SubwayLauncher context) {
        super(context);
    }

    @Override
    public SubwayStatus process() {
        PathFeatureKeyword pathFeatureKeyword = inputView.inputPathFeature();
        if (pathFeatureKeyword.equals(PathFeatureKeyword.DISTANCE) ||
                pathFeatureKeyword.equals(PathFeatureKeyword.TIME)) {
            return new InputStationStatus(context, pathFeatureKeyword);
        }
        // back
        return new MainFeatureStatus(context);
    }
}
