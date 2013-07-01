package chichikov.antroute.core;

import org.junit.Before;
import org.junit.Test;

import static chichikov.antroute.core.CoreFactory.getPosition;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * PositionTest
 *
 * @author Anatoly Chichikov (30.06.2013)
 */
public class PositionTest {

    Positionable
        position,
        equalPosition,
        nonEqualPosition;

    @Before
    @Test
    public void initTests() {
        position = getPosition(2, 3);
        equalPosition = getPosition(2, 3);
        nonEqualPosition = getPosition(4, 5);
    }

    @Test
    public void testInitialization() {
        assertNotNull(position);
        assertNotNull(equalPosition);
        assertNotNull(nonEqualPosition);
        assertFalse(position == equalPosition);
        assertFalse(equalPosition == nonEqualPosition);
        assertFalse(nonEqualPosition == position);
        assertThat(position.getX(), is(2));
        assertThat(position.getY(), is(3));
    }

    @Test
    public void testEquality() {
        assertTrue(position.equals(equalPosition));
        assertTrue(equalPosition.equals(position));
        assertFalse(position.equals(nonEqualPosition));
        assertFalse(nonEqualPosition.equals(position));
    }

    @Test
    public void testHashes() {
        assertEquals(position.hashCode(), equalPosition.hashCode());
        assertNotEquals(position.hashCode(), nonEqualPosition.hashCode());
    }

    @Test
    public void testComparability() {
        assertThat(position.compareTo(equalPosition), is(0));
        assertThat(equalPosition.compareTo(position), is(0));
        assertThat(position.compareTo(nonEqualPosition), is(-1));
        assertThat(nonEqualPosition.compareTo(position), is(1));
    }
}
