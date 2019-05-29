package model.entity;

import model.entity.entityBehaviours.IDestructable;
import model.entity.entityBehaviours.PlayerDestructable;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Rock extends Entity {

    IDestructable destructable;
    private char sprite = 'r';

    public Rock(int x, int y, Entity[][] map) {
        super(x, y, map);
        destructable = new PlayerDestructable();
    }

    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("./sprites/rock.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public char getSprite() {
        return sprite;
    }

}
