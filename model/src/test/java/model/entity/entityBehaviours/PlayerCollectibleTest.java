package model.entity.entityBehaviours;

import model.entity.Diamond;
import model.entity.Entity;
import model.entity.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerCollectibleTest {

    Player player;
    Diamond diamond;
    Entity[][] map;

    @Before
    public void setUp() throws Exception {
        map = new Entity[2][2];
        player = Player.getInstance(0, 1, map);
        player.map[0][1] = player;
        diamond = new Diamond(0, 0, map);
        diamond.map[0][0] = diamond;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void collectTest() {
        int exoectedScore = 10;
        diamond.collect
        assertEquals(expectedEntity, map[0][0]);
    }
}