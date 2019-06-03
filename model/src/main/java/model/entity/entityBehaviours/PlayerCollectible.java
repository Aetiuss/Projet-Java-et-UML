package model.entity.entityBehaviours;

import model.entity.Exit;

import java.util.Observable;
import java.util.Observer;


/**
 * The Class PlayerCollectible.
 *
 * @author Luc Anthoni
 */

public class PlayerCollectible implements Observer {

    Exit exit = Exit.getInstance();

    /**
     * Build the default PlayerCollectible
     */
    public PlayerCollectible() {
    }

    /**
     * Collect the object calling this method and increment 10 to the Score
     */
    public void collect() {

        exit.setScore(exit.getScore() + 10);
        System.out.println(exit.getScore());
    }

    /**
     * Update the thing
     */
    @Override
    public void update(Observable o, Object arg) {

    }
}
