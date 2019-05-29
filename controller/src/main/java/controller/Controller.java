package controller;


import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import model.entity.Player;


/**
 * The Class Controller.
 */
public final class Controller implements IController {

    /**
     * The view.
     */
    private IView view;

    /**
     * The model.
     */
    private IModel model;

    /**
     * The player.
     */
    private Player player;

    /**
     * Instantiates a new controller.
     *
     * @param view  the view
     * @param model the model
     */
    public Controller(final IView view, final IModel model) {
        this.view = view;
        this.model = model;
        this.player = Player.getInstance();
    }

    public void run() {
        this.model.run();
        this.view.run();
    }
    
    public void gravityThread() throws InterruptedException
    {
        this.model.gravity();
    }

    /**
     * Order perform.
     *
     * @param controllerOrder the controller order
     */
    public void orderPerform(final ControllerOrder controllerOrder) {
        switch (controllerOrder) {
            case Up:
                this.player.moveUp();
                break;
            case Down:
                this.player.moveDown();
                break;
            case Left:
                this.player.moveLeft();
                break;
            case Right:
                this.player.moveRight();
                break;
            default:
                break;
        }
        this.view.followPlayer();
    }
}
