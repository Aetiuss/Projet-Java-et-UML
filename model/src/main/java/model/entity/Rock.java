package model.entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

/**
 * The rock class
 *
 * @author Victor Bernard
 * @version 1.0
 */
public class Rock extends Entity {

    /**
     * Create some rocks
     * @param x The x position of the object
     * @param y The y position of the object
     * @param map The map
     */
    public Rock(int x, int y, Entity[][] map) {
        super(x, y, map);
    }

    /**
     * Load the image of the class
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
     *  Get the sprite of the rock
     * @return The sprite of the class
     */
    @Override
    public char getSprite() {
        return 'r';
    }

}
