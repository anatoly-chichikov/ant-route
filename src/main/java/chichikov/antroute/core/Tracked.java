package chichikov.antroute.core;

import java.util.List;

/**
 * Tracked
 *
 * @author Anatoly Chichikov (30.06.2013)
 */
public interface Tracked {

    public void addPositions(Positionable... position);
    public List<Positionable> toList();
}
