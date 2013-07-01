package chichikov.antroute.core;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static chichikov.antroute.core.CoreFactory.getPosition;
import static chichikov.antroute.core.CoreFactory.getRoute;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * RouteTest
 *
 * @author Anatoly Chichikov (30.06.2013)
 */
public class RouteTest {

    Tracked
        route,
        equalRoute,
        nonEqualRoute;

    @Before
    @Test
    public void initTests() {
        route = getRoute();
        route.addPositions(
            getPosition(1, 1),
            getPosition(3, 2),
            getPosition(5, 8),
            getPosition(2, 3),
            getPosition(1, 1),
            getPosition(1, 6),
            getPosition(2, 6));

        equalRoute = getRoute();
        equalRoute.addPositions(
            getPosition(1, 1),
            getPosition(1, 6),
            getPosition(2, 3),
            getPosition(2, 6),
            getPosition(3, 2),
            getPosition(5, 8));

        nonEqualRoute = getRoute();
        nonEqualRoute.addPositions(
            getPosition(1, 1),
            getPosition(1, 6),
            getPosition(3, 2),
            getPosition(5, 8));
    }

    @Test
    public void testInitialization() {
        assertNotNull(route);
        assertNotNull(equalRoute);
        assertNotNull(nonEqualRoute);
        assertFalse(route == equalRoute);
        assertFalse(equalRoute == nonEqualRoute);
        assertFalse(nonEqualRoute == route);
    }

    @Test
    public void testToListMethod() {
        List list = route.toList();
        assertThat(list.size(), is(6));
        assertEquals(list.get(0), getPosition(1, 1));
        assertEquals(list.get(1), getPosition(1, 6));
        assertEquals(list.get(2), getPosition(2, 3));
        assertEquals(list.get(3), getPosition(2, 6));
        assertEquals(list.get(4), getPosition(3, 2));
        assertEquals(list.get(5), getPosition(5, 8));
    }

    @Test
    public void testEquality() {
        assertTrue(route.equals(route));
        assertTrue(route.equals(equalRoute));
        assertTrue(equalRoute.equals(route));
        assertFalse(route.equals(nonEqualRoute));
        assertFalse(equalRoute.equals(nonEqualRoute));
    }

    @Test
    public void testHashes() {
        assertEquals(route.hashCode(), route.hashCode());
        assertEquals(route.hashCode(), equalRoute.hashCode());
        assertNotEquals(route.hashCode(), nonEqualRoute.hashCode());
        assertNotEquals(equalRoute.hashCode(), nonEqualRoute.hashCode());
    }
}
