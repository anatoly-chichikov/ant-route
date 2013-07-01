package chichikov.antroute.core;

/**
 * CoreFactory
 *
 * @author Anatoly Chichikov (30.06.2013)
 */
public class CoreFactory {

    public static Positionable getPosition(int x, int y) {
        return new Position(x, y);
    }

    public static Tracked getRoute() {
        return new Route();
    }

    public static Tracked getRoute(Positionable... positions) {
        Tracked route = new Route();
        route.addPositions(positions);
        return route;
    }

    public static Tracked getRoute(Tracked tracked) {
        Tracked route = new Route();
        route.addPositions(tracked.toList().toArray(new Positionable[1]));
        return route;
    }

    public static RoutesGenerator getGenerator() {
        return new RoutesGenerator();
    }
}
