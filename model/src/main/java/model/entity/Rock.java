package model.entity;

import model.entity.entityBehaviours.IDestructable;
import model.entity.entityBehaviours.PlayerCollectible;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Rock extends Entity {

    public IDestructable destructable;
    private char sprite = 'r';

    public Rock(int x, int y, Entity[][] map) {
        super(x, y, map);
        destructable = new PlayerCollectible();
    }

    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("./sprites/rock.png"));
            if (this.image == null) {
                throw new IOException("File is nowhere to be found");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public char getSprite() {
        return sprite;
    }

}
