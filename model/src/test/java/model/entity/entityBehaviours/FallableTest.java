package model.entity.entityBehaviours;

import model.entity.Diamond;
import model.entity.Empty;
import model.entity.Entity;
import model.entity.Rock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The test of the fallable class
 */
public class FallableTest {

    /**
     * A diamond
     */
    private Diamond diamond;

    /**
     * Setup before the test
     */
    @Before
    public void setUp() {
        Entity[][] map = new Entity[1][3];
        diamond = new Diamond(0, 0, map);
        Empty empty = new Empty(0, 1, map);
        Rock rock = new Rock(0, 2, map);
        diamond.map[0][0] = diamond;
        diamond.map[0][1] = empty;
        diamond.map[0][2] = rock;
    }


    /**
     * Test of the falling method
     */
    @Test
    public void testSetFalling() {
        diamond.fallable.setFalling(true);
        final boolean expected = true;
        assertEquals(expected, diamond.fallable.falling);
    }

}