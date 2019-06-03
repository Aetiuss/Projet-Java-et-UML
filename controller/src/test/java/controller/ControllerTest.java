package controller;

import contract.ControllerOrder;
import model.Model;
import model.entity.Player;
import org.junit.jupiter.api.Test;
import view.View;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * The test of the class controller
 *
 * @author Théo Weimann
 * @version 1.2
 */
class ControllerTest {

    /**
     * Instance of the model
     */
    private Model model = new Model();
    /**
     * Instance of the view
     */
    private View view = new View();
    /**
     * Instance of the controller
     */
    private Controller controller = new Controller(view, model);

    /**
     * Test the method run.
     */
    @Test
    void run() {
        try {
            controller.run();
        } catch (final Exception e) {
            e.printStackTrace();
            fail("Something went wrong in model or view");
        }
    }

    /**
     * Test the method timedThread.
     */
    @Test
    void gravityThread() {
        try {
            controller.timedThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail("Can't create thread or thread crash");
        }
    }

    /**
     * Test the method orderPerform.
     */
    @Test
    void orderPerform() {
        view.run();
        int previousY = Player.getInstance().y;
        controller.orderPerform(ControllerOrder.Up);
        assertEquals(previousY - 1, Player.getInstance().y);
    }


}
