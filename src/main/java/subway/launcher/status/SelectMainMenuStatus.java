package subway.launcher.status;

import subway.launcher.context.SystemContext;
import subway.view.InputView;
import subway.view.OutputView;

public class SelectMainMenuStatus implements BasicStatus{
    @Override
    public BasicStatus next(SystemContext context, InputView inputView, OutputView outputView) {
        return inputView.readMainMenuCommand().getNextStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
