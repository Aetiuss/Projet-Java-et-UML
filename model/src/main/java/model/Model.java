package model;

import contract.IModel;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

/**
 * Model of the project contain all the basic information needed about data and their operations.
 *
 * @author Théo Weimann
 * @version 1.0
 */
public final class Model extends Observable implements IModel {

    /**
     * The Map
     */
    private Map map = Map.getInstance();

    /**
     * Constructor of the class model
     */
    public Model() {
        DAO.getInstance().acquireFromDB(1);
    }


    /**
     * The thread that is used to
     *
     * @throws InterruptedException When the thread is blocking somehow
     */
    @Override
    public void timedEvent() throws InterruptedException {
        for (int i = map.getHeight() - 1; i >= 0; i--) {
            for (int j = map.getWidth() - 1; j >= 0; j--) {
                Map.getInstance().getMap()[i][j].setChecked(false);
            }
        }

        for (int i = map.getHeight() - 1; i >= 0; i--) {
            for (int j = map.getWidth() - 1; j >= 0; j--) {
                if (!Map.getInstance().getMap()[i][j].isChecked()) {
                    Map.getInstance().getMap()[i][j].setChecked(true);
                    switch (map.map[i][j].getSprite()) {

                        case 'd':
                            Map.getInstance().getMap()[i][j].fallable.fall();
                            break;
                        case 'f':
                            Map.getInstance().getMap()[i][j].fallable.fall();
                            break;
                        case 'm':
                            Map.getInstance()
                                    .getMap()[i][j].move();
                            break;
                    }

                }
            }
        }
        TimeUnit.MILLISECONDS.sleep(300);

    }


}
