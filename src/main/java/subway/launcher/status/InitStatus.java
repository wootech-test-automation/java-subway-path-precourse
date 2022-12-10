package subway.launcher.status;

import subway.launcher.context.SystemContext;
import subway.view.InputView;
import subway.view.OutputView;

public class InitStatus implements BasicStatus {
    @Override
    public BasicStatus next(SystemContext context, InputView inputView, OutputView outputView) {
        return new SelectMainMenuStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
