package subway.launcher.status;

import subway.launcher.context.SystemContext;
import subway.view.InputView;
import subway.view.OutputView;

public interface BasicStatus {
    BasicStatus next(SystemContext context, InputView inputView, OutputView outputView);
    boolean runnable();
}
