package subway.launcher.status;

import subway.domain.SubwayGame;
import subway.launcher.SubwayLauncher;
import subway.view.InputView;
import subway.view.OutputView;

public abstract class AbstractUnRunnableSubwayStatus implements SubwayStatus {

    protected final SubwayLauncher context;
    protected final InputView inputView;
    protected final OutputView outputView;
    protected final SubwayGame subwayGame;

    public AbstractUnRunnableSubwayStatus(SubwayLauncher context) {
        this.context = context;
        this.inputView = context.getInputView();
        this.outputView = context.getOutputView();
        this.subwayGame = context.getSubwayGame();
    }

    @Override
    public boolean isRunnable() {
        return false;
    }
}
