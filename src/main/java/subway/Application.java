package subway;


import subway.domain.InitRepositoryHelper;
import subway.launcher.SubwayLauncher;

public class Application {
    public static void main(String[] args) {
        InitRepositoryHelper.init();
        SubwayLauncher subwayLauncher = new SubwayLauncher();
        subwayLauncher.play();
    }
}
