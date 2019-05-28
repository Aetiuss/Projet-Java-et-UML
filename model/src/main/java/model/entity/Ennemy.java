package model.entity;

import model.entity.entityBehaviours.FallableDestrutable;
import model.entity.entityBehaviours.IDestructable;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Ennemy extends Entity {

    IDestructable destructableF;
    private char sprite = 'm';

    public Ennemy(int x, int y, Entity[][] map) {
        super(x, y, map);
        destructableF = new FallableDestrutable();
    }

    @Override
    public char getSprite() {
        return sprite;
    }

    @Override
    public void loadImage() {

        try {
            this.image = ImageIO.read(new File("C:\\Users\\theow\\Projet\\Code\\Projet-Java-et-UML\\model\\src\\main\\resources\\sprites\\ennemy.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
