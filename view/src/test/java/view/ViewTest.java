package view;

import model.entity.Player;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ViewTest {

    private Rectangle expectedRectangle = new Rectangle(Player.getInstance().x - 5, Player.getInstance().y - 5, 11, 11);
    private View view = new View();

    /**
     * Test the method run.
     */
    @Test
    public void run() {
        try {
            view.run();
        } catch (final Exception e) {
            e.printStackTrace();
            fail("Can't create object boardFrame due to incorrect parameter");
        }
    }

    /**
     * Test the method followPlayer.
     */
    @Test
    public void followPlayer() {
        this.view.run();
        this.view.followPlayer();
        assertEquals(expectedRectangle, this.view.getCloseView());
    }

}