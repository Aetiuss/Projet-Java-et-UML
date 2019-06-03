package model.entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Empty extends Entity {

    /**
     * @param x
     * @param y
     * @param map
     */
    public Empty(int x, int y, Entity[][] map) {
        super(x, y, map);
    }

    /**
     *
     * @return the sprite of the class
     */
    @Override
    public char getSprite() {
        return 'v';
    }

    /**
     * load the image of the class
     */
    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("./sprites/cobblestone.png")));
            if (this.image == null) {
                throw new IOException("File is nowhere to be found");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
