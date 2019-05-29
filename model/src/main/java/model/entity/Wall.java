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
            this.image = ImageIO.read(getClass().getClassLoader().getResource("./sprites/wall.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public char getSprite() {
        return sprite;
    }

}
