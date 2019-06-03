package model.entity;

import model.entity.entityBehaviours.Fallable;
import model.entity.entityBehaviours.Pushable;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class FallingRock extends Entity {

    /**
     * @param x
     * @param y
     * @param map
     */
    public FallingRock(int x, int y, Entity[][] map) {
        super(x, y, map);
        fallable = new Fallable(this);
        pushable = new Pushable(this);
    }

    /**
     *
     * @return the sprite of the class
     */
    @Override
    public char getSprite() {
        return 'f';
    }

    /**
     * load the image of the class
     */
    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("./sprites/gravel.png")));
            if (this.image == null) {
                throw new IOException("File is nowhere to be found");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }


}
