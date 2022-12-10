package subway.launcher.status;

import subway.launcher.context.SystemContext;
import subway.view.InputView;
import subway.view.OutputView;

public class InputStationStatus implements BasicStatus {

    private final BasicStatus nextStatus;
    public InputStationStatus(final BasicStatus nextStatus) {
        this.nextStatus = nextStatus;
    }

    @Override
    public BasicStatus next(SystemContext context, InputView inputView, OutputView outputView) {
        var stationDivision = inputView.readStationDivision();
        context.initializeStationDivision(stationDivision);
        return nextStatus;
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
