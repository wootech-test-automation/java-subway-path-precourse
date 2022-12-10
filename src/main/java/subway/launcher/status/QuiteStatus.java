package subway.launcher.status;

import subway.launcher.context.SystemContext;
import subway.view.InputView;
import subway.view.OutputView;

public class QuiteStatus implements BasicStatus {
    @Override
    public BasicStatus next(SystemContext context, InputView inputView, OutputView outputView) {
        return null;
    }

    @Override
    public boolean runnable() {
        return false;
    }
}
