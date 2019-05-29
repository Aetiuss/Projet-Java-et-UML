package model.entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Exit extends Entity {
    private char sprite = 'e';

    public Exit(int x, int y, Entity[][] map) {
        super(x, y, map);
    }

    @Override
    public char getSprite() {
        return sprite;
    }

    @Override
    public void loadImage() {

        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("./sprites/wall.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
