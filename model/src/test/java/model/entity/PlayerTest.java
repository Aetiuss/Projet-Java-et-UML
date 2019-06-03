package model.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The test of the class player
 *
 * @author Victor Bernard
 * @version 1.0
 */
public class PlayerTest {

    /**
     * The player
     */
    private Player player;

    /**
     * The setup of the tests
     */
    @Before
    public void setUp() {
        Entity[][] map = new Entity[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = new Empty(i, j, map);
            }
        }
        player = Player.getInstance(1, 1, map);
        player.map[1][1] = player;
    }


    /**
     * Test of the method to move UP
     */
    @Test
    public void moveUpTest() {
        int expectedY = 0;
        Player expectedP = player;
        player.moveUp();
        assertEquals(expectedY, player.y);
        assertEquals(expectedP, player.map[player.x][player.y]);
    }

    /**
     * Test of the method to move DOWN
     */
    @Test
    public void moveDownTest() {
        int expectedY = 2;
        player.moveDown();
        assertEquals(expectedY, player.y);
    }

    /**
     * Test of the method to move LEFT
     */
    @Test
    public void moveLeftTest() {
        int expectedX = 0;
        player.moveLeft();
        assertEquals(expectedX, player.x);
    }

    /**
     * Test of the method to move RIGHT
     */
    @Test
    public void moveRightTest() {
        int expectedX = 2;
        player.moveRight();
        assertEquals(expectedX, player.x);
    }

    /**
     * Test of the method to get the sprite
     */
    @Test
    public void getSprite() {
        char expectedSprite = 'p';
        assertEquals(expectedSprite, player.getSprite());
    }

}