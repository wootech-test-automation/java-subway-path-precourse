package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.type.Route;

public class RouteRepository {
    private static final List<Route> routes = new ArrayList<>();

    public static List<Route> routes() {
        return Collections.unmodifiableList(routes);
    }

    public static void addRoute(Route route) {
        routes.add(route);
    }

    public static void addAll(List<Route> allRoutes) {
        routes.addAll(allRoutes);
    }

    // 출발역, 도착역 이름을 통해 해당하는 경로를 찾습니다.
    public static Route findByStationsName(String stationName1, String stationName2) {
        for (Route route : routes) {
            if (route.getStationsName().contains(stationName1) && route.getStationsName().contains(stationName2)) {
                return route;
            }
        }
        return null;
    }
}
