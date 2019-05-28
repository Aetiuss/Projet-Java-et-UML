package model.entity;

import javax.imageio.ImageIO;
import java.io.File;
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
            this.image = ImageIO.read(new File("C:\\Users\\theow\\Projet\\Code\\Projet-Java-et-UML\\model\\src\\main\\java\\model\\entity\\Wall.java"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
