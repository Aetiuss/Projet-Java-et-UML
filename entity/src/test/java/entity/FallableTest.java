package entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FallableTest
{
    
    Diamond diamond;
    Entity[][] map;
    @Before
    public void setUp() throws Exception
    {
        map = new Entity[1][2];
        diamond = new Diamond(0, 1, map);
        map[0][1] = diamond;
    }
    @After
    public void tearDown() throws Exception
    {
    }
    @Test
    public void testfall()
    {
        diamond.fallable.fall();
        final int expectedY = 0;
        final boolean expectedFalling = true;
        final Entity expectedEntity = diamond;
        assertEquals(expectedY, diamond.y);
        assertEquals(expectedFalling, diamond.fallable.falling);
        assertNotNull(map[0][diamond.y]);
        assertEquals(expectedEntity, map[0][0]);
    }
    
}