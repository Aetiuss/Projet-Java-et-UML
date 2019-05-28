package model.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FallableTest
{
    
    private Diamond diamond;
    Entity[][] map;
    @Before
    public void setUp() throws Exception
    {
        map = new Entity[1][2];
        diamond = new Diamond(0, 1, map);
        diamond.map[0][1] = diamond;
    }
    @Test
    public void testfall()
    {
        diamond.fallable.fall();
        final int expectedY = 0;
        assertEquals(expectedY, diamond.y);
        final boolean expectedBool = true;
        assertEquals(expectedBool, diamond.fallable.falling);
        assertNotNull(diamond.map[0][0]);
    }
    @Test
    public void testsetFalling()
    {
        diamond.fallable.setFalling(true);
        final boolean expected = true;
        assertEquals(expected, diamond.fallable.falling);
    }
}