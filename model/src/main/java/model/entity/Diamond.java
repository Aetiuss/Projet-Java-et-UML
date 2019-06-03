package model.entity;

import model.entity.entityBehaviours.Fallable;
import model.entity.entityBehaviours.PlayerCollectible;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Diamond extends Entity {

    /**
     * @param x
     * @param y
     * @param map
     */
    public Diamond(int x, int y, Entity[][] map) {
        super(x, y, map);
        fallable = new Fallable(this);
        collectibleP = new PlayerCollectible();
    }

    /**
     *
     * @return the sprite of the class
     */
    @Override
    public char getSprite() {
        return 'd';
    }

    /**
     * load the image of the class
     */
    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("./sprites/diamond_ore.png")));
            if (this.image == null) {
                throw new IOException("File is nowhere to be found");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
