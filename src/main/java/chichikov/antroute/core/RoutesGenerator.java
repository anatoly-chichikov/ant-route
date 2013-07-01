package chichikov.antroute.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static chichikov.antroute.core.CoreFactory.getPosition;
import static chichikov.antroute.core.CoreFactory.getRoute;

/**
 * RoutesGenerator
 *
 * @author Anatoly Chichikov (30.06.2013)
 */
public class RoutesGenerator {

    HashSet<Tracked> routes;

    RoutesGenerator() {
        routes = new HashSet<Tracked>();
    }

    public List<Tracked> generateAllPossibleRoutes(Positionable startPoint, Positionable endPoint) {
        if ((startPoint.getX() > endPoint.getX()) || (startPoint.getY() > endPoint.getY()))
            throw new UnsupportedOperationException();
        calculateRightAndDownRoute(startPoint, endPoint, getRoute());
        return new ArrayList<Tracked>(routes);
    }

    private void calculateRightAndDownRoute(Positionable interimPoint, Positionable endPoint, Tracked interimRoute) {
        interimRoute.addPositions(interimPoint);

        if (interimPoint.equals(endPoint)) {
            interimRoute.addPositions(interimPoint);
            routes.add(interimRoute);
            return;
        }
        if (interimPoint.getX() > endPoint.getX()) return;
        if (interimPoint.getY() > endPoint.getY()) return;

        calculateRightAndDownRoute(
            getPosition(interimPoint.getX() + 1, interimPoint.getY()),
            endPoint,
            getRoute(interimRoute));
        calculateRightAndDownRoute(
            getPosition(interimPoint.getX(), interimPoint.getY() + 1),
            endPoint,
            getRoute(interimRoute));
    }
}
