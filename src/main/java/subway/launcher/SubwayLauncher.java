package subway.launcher;

import subway.domain.SubwayGame;
import subway.launcher.status.MainFeatureStatus;
import subway.launcher.status.SubwayStatus;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayLauncher {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final SubwayGame subwayGame = new SubwayGame();
    private SubwayStatus subwayStatus = new MainFeatureStatus(this);

    public void play() {
        while (subwayStatus.isRunnable()) {
            try {
                subwayStatus = subwayStatus.process();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            } catch (IllegalStateException e) {
                outputView.printError(e.getMessage());
                break;
            }
        }
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public SubwayGame getSubwayGame() {
        return subwayGame;
    }
}
