package model.entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Wall extends Entity {

    private char sprite = 'w';

    public Wall(int x, int y, Entity[][] map) {
        super(x, y, map);
    }

    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("./sprites/bedrock.png"));
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
