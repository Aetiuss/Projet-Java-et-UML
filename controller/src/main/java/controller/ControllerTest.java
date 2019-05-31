package controller;

import contract.ControllerOrder;
import model.Map;
import model.Model;
import model.entity.Player;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import view.View;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ControllerTest {


    final private char[][] demoMap = {{'p', 'r'}};
    private Model model = new Model();
    private View view = new View();
    private Controller controller = new Controller(view, model);
    private Map map = Map.getInstance();

    @Before
    public void setUp() {

    }

    @Test
    public void run() {
        try {
            controller.run();
        } catch (final Exception e) {
            e.printStackTrace();
            fail("Something went wrong in model or view");
        }
    }

    @Test
    public void gravityThread() {
        try {
            controller.gravityThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail("Can't create thread or thread crash");
        }
    }

    @Test
    public void orderPerform() {
        int previousX = Player.getInstance().x;
        int previousY = Player.getInstance().y;
        controller.orderPerform(ControllerOrder.Up);
        assertEquals(previousY + 1, Player.getInstance().y);
    }


}