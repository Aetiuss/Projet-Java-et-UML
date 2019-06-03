package model.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PushableTest {

    private FallingRock fallingRock;

    @Before
    public void setUp() {
        Entity[][] map = new Entity[3][1];
        fallingRock = new FallingRock(1, 0, map);
        fallingRock.map[1][0] = fallingRock;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPushRight() {
        fallingRock.pushable.pushRight();
        final int expected = 2;
        assertEquals(expected, fallingRock.x);
        assertNotNull(fallingRock.map[2][0]);
    }

    @Test
    public void testPushLeft() {
        fallingRock.pushable.pushLeft();
        final int expected = 0;
        assertEquals(expected, fallingRock.x);
        assertNotNull(fallingRock.map[0][0]);
    }

}