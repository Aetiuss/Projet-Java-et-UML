package main;

import controller.Controller;
import model.Model;
import model.entity.Player;
import view.View;

/**
 * The Class Main.
 * @author Théo Weimann
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     * @param args Main's argument.
     */
    public static void main(final String[] args) throws InterruptedException
    {
        final Model model = new Model();
        final View view = new View();
        final Controller controller = new Controller(view, model);
        view.setController(controller);
        controller.run();
        do {
            controller.timedThread();
        } while (Player.getInstance().isAlive());
    }
}
