package model.entity;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Empty extends Entity {

    private char sprite = 'v';

    public Empty(int x, int y, Entity[][] map) {
        super(x, y, map);
    }

    @Override
    public char getSprite() {
        return sprite;
    }

    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(new File("C:\\Users\\theow\\Projet\\Code\\Projet-Java-et-UML\\model\\src\\main\\resources\\sprites\\ground.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
