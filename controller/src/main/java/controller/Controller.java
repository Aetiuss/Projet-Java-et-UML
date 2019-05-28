package controller;


import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Player;


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
        this.setView(view);
        this.setModel(model);
        this.player = Player.getInstance();
    }

    /**
     *
     *
     */

    public void run() {
        orderPerform(this.view.c); //AJOUTER
    }

    /**
     * Sets the view.
     *
     * @param view The new view
     */
    private void setView(final IView view) {
        this.view = view;
    }

    /**
     * Sets the model.
     *
     * @param model The new model
     */
    private void setModel(final IModel model) {
        this.model = model;
    }

    /**
     * Order perform.
     *
     * @param controllerOrder the controller order
     */
    /*
     * (non-Javadoc)
     *
     * @see contract.IController#orderPerform(contract.ControllerOrder)
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
    }

}
