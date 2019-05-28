package entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FallableTest
{
    
    Diamond diamond;
    @Before
    public void setUp() throws Exception
    {
        diamond = new Diamond(1, 2);
    }
    @After
    public void tearDown() throws Exception
    {
    }
    @Test
    public void testfall()
    {
        diamond.fallable.fall();
        final int expectedY = 1;
        final boolean expectedFalling = true;
        assertEquals(expectedY, diamond.y);
        assertEquals(expectedFalling, diamond.fallable.falling);
    }
    
}