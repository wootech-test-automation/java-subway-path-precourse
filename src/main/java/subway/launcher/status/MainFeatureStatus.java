package subway.launcher.status;

import subway.launcher.SubwayLauncher;
import subway.launcher.keyword.MainFeatureKeyword;

public class MainFeatureStatus extends AbstractRunnableSubwayStatus {

    public MainFeatureStatus(SubwayLauncher context) {
        super(context);
    }

    @Override
    public SubwayStatus process() {
        MainFeatureKeyword mainFeatureKeyword = inputView.inputMainFeature();
        if (mainFeatureKeyword.equals(MainFeatureKeyword.SEARCH)) {
            return new PathFeatureStatus(context);
        }
        // quit
        return new QuitStatus(context);
    }
}
