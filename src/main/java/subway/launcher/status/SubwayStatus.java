package subway.launcher.status;

public interface SubwayStatus {

    SubwayStatus process();

    boolean isRunnable();
}
