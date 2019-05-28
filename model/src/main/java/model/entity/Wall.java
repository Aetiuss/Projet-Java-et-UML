package model.entity;

import model.entity.entityBehaviours.FallableDestrutable;
import model.entity.entityBehaviours.IDestructable;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Wall extends Entity {

    IDestructable destructable;
    private char sprite = 'w';

    public Wall(int x, int y, Entity[][] map) {
        super(x, y, map);
        destructable = new FallableDestrutable();
    }

    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(new File("C:\\Users\\theow\\Projet\\Code\\Projet-Java-et-UML\\model\\src\\main\\resources\\sprites\\wall.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public char getSprite() {
        return sprite;
    }

}
