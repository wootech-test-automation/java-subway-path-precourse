package subway.launcher;

import java.util.NoSuchElementException;
import subway.exception.InvalidInputException;
import subway.launcher.context.SystemContext;
import subway.launcher.status.BasicStatus;
import subway.launcher.status.InitStatus;
import subway.launcher.status.QuiteStatus;
import subway.view.InputView;
import subway.view.OutputView;

public class SystemLauncher {

    private final InputView inputView;
    private final OutputView outputView;
    private final SystemContext context;

    public SystemLauncher(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.context = new SystemContext();
    }

    public void execute(){
        BasicStatus status = new InitStatus();
        while(status.runnable()) {
            try {
                status = status.next(context, inputView, outputView);
            } catch (InvalidInputException exception){
                outputView.printError(exception.getMessage());
            }catch (NoSuchElementException exception){
                outputView.printError(exception.getMessage());
                status = new QuiteStatus();
            }
        }
    }
}
