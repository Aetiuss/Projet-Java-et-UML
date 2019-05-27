package Java.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PushableTest
{
    
    FallingRock fallingRock;
    @Before
    public void setUp() throws Exception
    {
        fallingRock = new FallingRock(1, 2);
    }
    @After
    public void tearDown() throws Exception
    {
    }
    @Test
    public void testpushRight()
    {
        fallingRock.pushable.pushRight();
        final int expected = 2;
        assertEquals(expected, fallingRock.x);
    }
    @Test
    public void testpushLeft()
    {
        fallingRock.pushable.pushLeft();
        final int expected = 0;
        assertEquals(expected, fallingRock.x);
    }
    
}