package model.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnnemyTest
{
    
    Entity[][] map;
    Ennemy     ennemy;
    Wall wall1, wall2, wall3, wall4, wall5, wall6;
    Empty empty;
    @Before
    public void setUp() throws Exception
    {
        map = new Entity[4][4];
        ennemy = new Ennemy(1, 1, map);
        wall1 = new Wall(0, 1, map);
        wall2 = new Wall(1, 0, map);
        wall3 = new Wall(1, 2, map);
        wall4 = new Wall(2, 2, map);
        wall5 = new Wall(2, 0, map);
        wall6 = new Wall(3, 1, map);
        empty = new Empty(2, 1, map);
        map[1][1] = ennemy;
        map[0][1] = wall1;
        map[1][0] = wall2;
        map[1][2] = wall3;
        map[2][1] = empty;
        map[2][2] = wall4;
        map[2][0] = wall5;
        map[3][1] = wall6;

    }
    @After
    public void tearDown() throws Exception
    {
    }
    @Test
    public void move()
    {
        ennemy.move();
        final int    expectedX = 2;
        final int    expectedY = 1;
        final Entity expected  = ennemy;
        assertEquals(expectedX, ennemy.x);
        assertEquals(expectedY, ennemy.y);
        assertEquals(expected, ennemy.map[2][1]);
    }
    
}