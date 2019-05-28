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
            this.image = ImageIO.read(new File("C:\\Users\\1944473\\IdeaProjects\\Projet-Java-et-UML\\model\\src\\main\\resources\\sprites\\wall.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
