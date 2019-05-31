package view;

import contract.ControllerOrder;
import contract.IController;
import contract.IView;
import contract.showboard.BoardFrame;
import model.Map;
import model.entity.Exit;
import model.entity.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The Class View.
 *
 * @author Théo Weimann
 */
public final class View implements IView, Runnable, KeyListener {

    /**
     * The size of each square that will be displayed.
     */
    final private int squareSize = 64;
    /**
     * The unique instance of the map.
     */
    final private Map map = Map.getInstance();
    /**
     * The unique instance of the player.
     */
    final private Player player = Player.getInstance();
    /**
     * The unique instance of the exit.
     */
    final private Exit exit = Exit.getInstance();
    /**
     * The rectangle that define the scope of the view.
     */
    private Rectangle closeView;
    /**
     * The controller.
     */
    private IController controller;
    /**
     * The board frame.
     */
    private BoardFrame boardFrame;
    /**
     * The score of the player
     */
    private int score = exit.getScore();

    /**
     * Build the default view scope with the position of the player.
     */
    public View() {
        this.setCloseView(new Rectangle(player.getX() - 5, player.getY() - 5, 11, 11));
    }

    /**
     * Method that convert the key input of the user to order that can be used by the controller.
     *
     * @param keyCode The code of the key pressed
     * @return Return the order
     */
    private static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_Z:
                return ControllerOrder.Up;
            case KeyEvent.VK_S:
                return ControllerOrder.Down;
            case KeyEvent.VK_Q:
                return ControllerOrder.Left;
            case KeyEvent.VK_D:
                return ControllerOrder.Right;
            default:
                return ControllerOrder.Nothing;
        }
    }

    /**
     *Implementation of the interface runnable, initialise the window.
     */
    public void run() {
        this.boardFrame = new BoardFrame("Boulder Dash");
        boardFrame.setDimension(new Dimension(this.map.getHeight(), this.map.getWidth()));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setHeightLooped(false);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);
        for (int x = 0; x < this.map.getHeight(); x++) {
            for (int y = 0; y < this.map.getWidth(); y++) {
                boardFrame.addSquare(this.map.getMap()[x][y], x, y);
            }
        }
        this.followPlayer();
        this.getScore(score);
        boardFrame.setVisible(true);

    }

    /**
     * Get the score
     *
     * @param score The score
     */
    private void getScore(int score) {
        boardFrame.getScore(score);
    }

    /**
     * Redefine the scope of view around the player so that he can be in the middle of the window.
     */
    public void followPlayer() {
        for (int x = 0; x < this.map.getHeight(); x++) {
            for (int y = 0; y < this.map.getWidth(); y++) {
                boardFrame.addSquare(this.map.getMap()[x][y], x, y);
            }
        }
        this.closeView.x = player.x - 5;
        this.closeView.y = player.y - 5;
        this.boardFrame.repaint();
    }


    /**
     * Set the view that will be displayed in the window.
     *
     * @param closeView The rectangle defining the view that will be used.
     */
    private void setCloseView(Rectangle closeView) {
        this.closeView = closeView;
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e A KeyEvent.
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param keyEvent A KeyEvent.
     */
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        this.controller.orderPerform(keyCodeToControllerOrder(keyEvent.getKeyCode()));
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e A KeyEvent.
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Set the controller
     * @param controller The controller that you want to use.
     */
    public void setController(IController controller) {
        this.controller = controller;
    }
}
