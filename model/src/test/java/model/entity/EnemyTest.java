package model.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The test for the class enemy (both Enemy1 and Enemy2)
 *
 * @author Victor Bernard
 * @version 1.0
 */
public class EnemyTest {

    /**
     * Instance of an enemy
     */
    private Enemy1 enemy;

    /**
     * Pre operation preparing dat for the tests
     */
    @Before
    public void setUp() {
        Entity[][] map = new Entity[4][4];
        enemy = new Enemy1(1, 1, map);
        Wall wall1 = new Wall(0, 1, map);
        Wall wall2 = new Wall(1, 0, map);
        Wall wall3 = new Wall(1, 2, map);
        Wall wall4 = new Wall(2, 2, map);
        Wall wall5 = new Wall(2, 0, map);
        Wall wall6 = new Wall(3, 1, map);
        Empty empty = new Empty(2, 1, map);
        map[1][1] = enemy;
        map[0][1] = wall1;
        map[1][0] = wall2;
        map[1][2] = wall3;
        map[2][1] = empty;
        map[2][2] = wall4;
        map[2][0] = wall5;
        map[3][1] = wall6;

    }

    /**
     * Test the method move from class Enemy
     */
    @Test
    public void move() {
        enemy.move();
        final int expectedX = 2;
        final int expectedY = 1;
        final Entity expected = enemy;
        assertEquals(expectedX, enemy.x);
        assertEquals(expectedY, enemy.y);
        assertEquals(expected, enemy.map[2][1]);
    }

}