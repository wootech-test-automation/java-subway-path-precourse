package subway.launcher.status;

import subway.domain.station.Station;
import subway.domain.station.StationDivision;
import subway.exception.InvalidInputException;
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

        context.initializeStationDivision(
                new StationDivision(
                        readUpStation(context, inputView, outputView),
                        readDownStation(context, inputView, outputView)
                )
        );
        return nextStatus;
    }

    private Station readDownStation(SystemContext context, InputView inputView, OutputView outputView) {
        while (true) {
            try {
                var station = inputView.readDownStation();
                context.validateExistsStation(station);
                return station;
            } catch (InvalidInputException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

    private Station readUpStation(SystemContext context, InputView inputView, OutputView outputView) {
        while (true) {
            try {
                var station = inputView.readUpStation();
                context.validateExistsStation(station);
                return station;
            } catch (InvalidInputException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
