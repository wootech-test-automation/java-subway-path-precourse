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
        var upStation = this.readStation(inputView,outputView);
        var terminalStation = this.readStation(inputView,outputView);

        context.initializeStationDivision(new StationDivision(upStation,terminalStation));
        
        return nextStatus;
    }

    private Station readStation(InputView inputView, OutputView outputView) {
        while(true){
            try {
                return inputView.readUpStation();
            }catch (InvalidInputException exception){
                outputView.printError(exception.getMessage());
            }
        }
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
