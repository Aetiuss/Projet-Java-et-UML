package view;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import contract.showboard.BoardFrame;
import model.Map;
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

    final private int squareSize = 16;
    private Map map;
    private Player player;
    private Rectangle closeView;
    private IController controller;

    public View(final IModel model) {
        this.map = Map.getInstance();
        this.player = Player.getInstance();
        this.setCloseView(new Rectangle(player.getX() - 5, player.getY() - 5, 10, 10));
    }

    protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
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

    public void run() {
        final BoardFrame boardFrame = new BoardFrame("Boulder Dash");
        boardFrame.setDimension((new Dimension(this.map.getWidth(), this.map.getHeight())));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setHeightLooped(false);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);
        for (int x = 0; x < this.map.getWidth(); x++) {
            for (int y = 0; y < this.map.getHeight(); y++) {
                boardFrame.addSquare(this.map.getMap()[x][y], x, y);
            }
        }
        for (int x = 0; x < this.map.getWidth(); x++) {
            for (int y = 0; y < this.map.getHeight(); y++) {
                map.getMap()[x][y].loadImage();
            }
        }
        this.followPlayer();
        boardFrame.setVisible(true);
    }

    private void followPlayer() {

    }


    public void setCloseView(Rectangle closeView) {
        this.closeView = closeView;
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param keyEvent
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
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setController(IController controller) {
        this.controller = controller;
    }
}
