package model.entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Wall extends Entity {

    /**
     * Create some wall
     * @param x The x position of the object
     * @param y The y position of the object
     * @param map The map
     */
    public Wall(int x, int y, Entity[][] map) {
        super(x, y, map);
    }

    /**
     * Load the image of the class
     */
    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("./sprites/bedrock.png")));
            if (this.image == null) {
                throw new IOException("File is nowhere to be found");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gte the sprite of the wall
     * @return the sprite of the class
     */
    @Override
    public char getSprite() {
        return 'w';
    }

}
