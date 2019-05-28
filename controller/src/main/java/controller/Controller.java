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


    /**
     * Order perform.
     *
     * @param controllerOrder the controller order
     */
    public void orderPerform(final ControllerOrder controllerOrder) {
        switch (controllerOrder) {
            case Up:
                System.out.println("UP");
                this.player.moveUp();
                break;
            case Down:
                System.out.println("DOWN");
                this.player.moveDown();
                break;
            case Left:
                System.out.println("LEFT");
                this.player.moveLeft();
                break;
            case Right:
                System.out.println("RIGHT");
                this.player.moveRight();
                break;
            default:
                break;
        }

        System.out.println("########################################################");
        System.out.println("########################################################");
        System.out.println("########################################################");
    }

}
