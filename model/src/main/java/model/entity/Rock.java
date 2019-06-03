package model.entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Rock extends Entity {

    /**
     * @param x
     * @param y
     * @param map
     */
    public Rock(int x, int y, Entity[][] map) {
        super(x, y, map);
    }

    /**
     * load the image of the class
     */
    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("./sprites/stone.png")));
            if (this.image == null) {
                throw new IOException("File is nowhere to be found");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return the sprite of the class
     */
    @Override
    public char getSprite() {
        return 'r';
    }

}
