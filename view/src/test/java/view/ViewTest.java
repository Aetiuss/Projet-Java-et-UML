package view;

import model.Model;
import model.entity.Player;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ViewTest {

    Rectangle expectedRectangle = new Rectangle(3 - 5, 2 - 5, 11, 11);
    private View view = new View();
    private Model model = new Model();
    private Player player = Player.getInstance();

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