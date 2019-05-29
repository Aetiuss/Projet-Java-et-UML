package model.entity.entityBehaviours;

import model.entity.Diamond;
import model.entity.Empty;
import model.entity.Entity;
import model.entity.Rock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FallableTest
{
    
    private Diamond diamond;
    private Rock    rock;
    private Empty   empty;
    Entity[][] map;
    @Before
    public void setUp() throws Exception
    {
        map = new Entity[1][3];
        diamond = new Diamond(0, 0, map);
        empty = new Empty(0, 1, map);
        rock = new Rock(0, 2, map);
        diamond.map[0][0] = diamond;
        diamond.map[0][1] = empty;
        diamond.map[0][2] = rock;
    }
    @Test
    public void testfall()
    {
        diamond.fallable.fall();
        int expectedY = 1;
        assertEquals(expectedY, diamond.y);
        boolean expectedBool = true;
        assertEquals(expectedBool, diamond.fallable.falling);
        assertNotNull(diamond.map[0][0]);
        diamond.fallable.fall();
        expectedY = 2;
        assertEquals(expectedY, diamond.y);
    }
    @Test
    public void testsetFalling()
    {
        diamond.fallable.setFalling(true);
        final boolean expected = true;
        assertEquals(expected, diamond.fallable.falling);
    }
    
}