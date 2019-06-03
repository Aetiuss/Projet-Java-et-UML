package model.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The tests of the pushable class
 */
public class PushableTest {

    /**
     * A falling rock
     */
    private FallingRock fallingRock;

    /**
     * The setup of the test
     */
    @Before
    public void setUp() {
        Entity[][] map = new Entity[3][1];
        fallingRock = new FallingRock(1, 0, map);
        fallingRock.map[1][0] = fallingRock;
    }


    /**
     * Test of the method push right
     */
    @Test
    public void testPushRight() {
        fallingRock.pushable.pushRight();
        final int expected = 2;
        assertEquals(expected, fallingRock.x);
        assertNotNull(fallingRock.map[2][0]);
    }

    /**
     * The test of the method push left
     */
    @Test
    public void testPushLeft() {
        fallingRock.pushable.pushLeft();
        final int expected = 0;
        assertEquals(expected, fallingRock.x);
        assertNotNull(fallingRock.map[0][0]);
    }

}