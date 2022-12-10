package subway.launcher.status;

import subway.launcher.SubwayLauncher;

public class QuitStatus extends AbstractUnRunnableSubwayStatus {

    public QuitStatus(SubwayLauncher context) {
        super(context);
    }

    @Override
    public SubwayStatus process() {
        return null;
    }
}
