package subway.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import subway.domain.station.Station;
import subway.exception.InvalidInputException;
import subway.launcher.code.ChildMenu;
import subway.launcher.code.MainMenu;

public class InputView extends IoPrinter {
    public MainMenu readMainMenuCommand() {
        this.printTitle("메인 화면");
        this.println(MainMenu.message());
        this.println();
        this.printTitle("원하는 기능을 선택하세요.");
        return MainMenu.from(this.readLineAfterNextLine());
    }

    public ChildMenu readChildMenuCommand() {
        this.printTitle("경로 기준");
        this.println(ChildMenu.message());
        this.println();
        this.printTitle("원하는 기능을 선택하세요");
        return ChildMenu.from(this.readLineAfterNextLine());

    }


    public Station readDownStation() {
        while (true) {
            try {
                this.printTitle("도착역을 입력하세요.");
                return new Station(this.readLineAfterNextLine());
            } catch (InvalidInputException exception) {
                this.error(exception.getMessage());
            }
        }
    }

    public Station readUpStation() {
        while (true) {
            try {
                this.printTitle("출발역을 입력하세요.");
                return new Station(this.readLineAfterNextLine());
            } catch (InvalidInputException exception) {
                this.error(exception.getMessage());
            }
        }
    }

    private String readLineAfterNextLine() {
        var input = readLine();
        this.println();
        return input;
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException exception) {
            throw new IllegalStateException("더이상 유효하지 않는 입력입니다.");
        }
    }
}
