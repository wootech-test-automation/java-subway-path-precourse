package subway.launcher.status;

import subway.domain.weight.WeightCode;
import subway.launcher.context.SystemContext;
import subway.view.InputView;
import subway.view.OutputView;

public class CalculateShortestTime implements BasicStatus {
    @Override
    public BasicStatus next(SystemContext context, InputView inputView, OutputView outputView) {
        outputView.printResult(context.calculateShortestByWeight(WeightCode.TIME));
        return new SelectMainMenuStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
