package chichikov.antroute.core;

import java.util.*;

/**
 * RouteUnit
 *
 * @author Anatoly Chichikov (30.06.2013)
 */
public class Route implements Tracked {

    private TreeSet<Positionable> allPositions;

    Route() {
        this.allPositions = new TreeSet<Positionable>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route)) return false;

        Route route = (Route) o;

        return allPositions.equals(route.allPositions);
    }

    @Override
    public int hashCode() {
        return allPositions.hashCode();
    }

    @Override
    public void addPositions(Positionable... position) {
        Collections.addAll(allPositions, position);
    }

    @Override
    public String toString() {
        return "RouteUnit = " + allPositions;
    }

    @Override
    public List<Positionable> toList() {
        if (allPositions.isEmpty()) return null;
        return new ArrayList<Positionable>(allPositions);
    }

}
