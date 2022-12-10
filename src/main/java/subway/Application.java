package subway;


import java.util.Scanner;
import subway.controller.SubwayPathController;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayPathController subwayPathController = new SubwayPathController();
        subwayPathController.run();
    }
}
