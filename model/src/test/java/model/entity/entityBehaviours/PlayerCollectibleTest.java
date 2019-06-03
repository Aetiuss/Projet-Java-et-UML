package model.entity.entityBehaviours;

import model.entity.Diamond;
import model.entity.Entity;
import model.entity.Exit;
import model.entity.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PlayerCollectibleTest {

    private Exit exit;
    private Diamond diamond;

    @Before
    public void setUp() {
        Entity[][] map = new Entity[2][2];
        Player player = Player.getInstance(0, 1, map);
        player.map[0][1] = player;
        diamond = new Diamond(0, 0, map);
        diamond.map[0][0] = diamond;
        exit = Exit.getInstance(1, 1, map);
        diamond.collectibleP.exit = exit;
        exit.map[1][1] = exit;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void collectTest() {
        int expectedScore = 10;
        exit.setScore(0);
        diamond.collectibleP.collect();
        assertEquals(expectedScore, exit.getScore());
    }
}