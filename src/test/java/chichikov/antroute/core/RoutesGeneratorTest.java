package chichikov.antroute.core;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static chichikov.antroute.core.CoreFactory.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * RoutesGeneratorTest
 *
 * @author Anatoly Chichikov (30.06.2013)
 */
public class RoutesGeneratorTest {

    RoutesGenerator generator;
    List<Tracked> routes;

    @Before
    @Test
    public void initTests() {
        generator = getGenerator();
    }

    @Test
    public void testInitialization() {
        assertNotNull(generator);
    }

    @Test
    public void test1x1Grid() {
        routes = generator.generateAllPossibleRoutes(getPosition(1, 1), getPosition(1, 1));
        assertThat(routes.size(), is(1));
        assertTrue(routes.contains(getRoute(getPosition(1, 1))));
    }

    @Test
    public void test2x2Grid() {
        routes = generator.generateAllPossibleRoutes(getPosition(1, 1), getPosition(2, 2));
        assertThat(routes.size(), is(2));
        assertTrue(
            routes.contains(
                getRoute(
                    getPosition(1, 1),
                    getPosition(2, 1),
                    getPosition(2, 2))));
        assertTrue(
            routes.contains(
                getRoute(
                    getPosition(1, 1),
                    getPosition(1, 2),
                    getPosition(2, 2))));
    }

    @Test
    public void test3x3Grid() {
        routes = generator.generateAllPossibleRoutes(getPosition(1, 1), getPosition(3, 3));
        assertThat(routes.size(), is(6));
        assertTrue(
            routes.contains(
                getRoute(
                    getPosition(1, 1),
                    getPosition(1, 2),
                    getPosition(1, 3),
                    getPosition(2, 3),
                    getPosition(3, 3))));
        assertTrue(
            routes.contains(
                getRoute(
                    getPosition(1, 1),
                    getPosition(1, 2),
                    getPosition(2, 2),
                    getPosition(3, 2),
                    getPosition(3, 3))));
        assertTrue(
            routes.contains(
                getRoute(
                    getPosition(1, 1),
                    getPosition(2, 1),
                    getPosition(2, 2),
                    getPosition(2, 3),
                    getPosition(3, 3))));
        assertTrue(
            routes.contains(
                getRoute(
                    getPosition(1, 1),
                    getPosition(1, 2),
                    getPosition(2, 2),
                    getPosition(2, 3),
                    getPosition(3, 3))));
        assertTrue(
            routes.contains(
                getRoute(
                    getPosition(1, 1),
                    getPosition(2, 1),
                    getPosition(2, 2),
                    getPosition(3, 2),
                    getPosition(3, 3))));
        assertTrue(
            routes.contains(
                getRoute(
                    getPosition(1, 1),
                    getPosition(2, 1),
                    getPosition(3, 1),
                    getPosition(3, 2),
                    getPosition(3, 3))));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testLargeStartPositionX() {
        generator.generateAllPossibleRoutes(getPosition(2, 3), getPosition(1, 5));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testLargeStartPositionY() {
        generator.generateAllPossibleRoutes(getPosition(1, 7), getPosition(2, 3));
    }
}
