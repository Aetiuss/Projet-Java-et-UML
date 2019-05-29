package model.entity.entityBehaviours;

import model.entity.Exit;

import java.util.Observable;
import java.util.Observer;

public class PlayerCollectible implements Observer {

    Exit exit = Exit.getInstance();

    public PlayerCollectible() {
    }


    public void collect() {
        exit.setScore(exit.getScore() + 10);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
