package model.entity;

import model.entity.entityBehaviours.Fallable;
import model.entity.entityBehaviours.Pushable;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FallingRock extends Entity
{
    
    Fallable fallable;
    Pushable pushable;

    private char sprite = 'f';
    public FallingRock(int x, int y, Entity[][] map)
    {
        super(x, y, map);
        fallable = new Fallable(this);
        pushable = new Pushable(this);
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    @Override
    public void loadImage()
    {
        try {
            this.image = ImageIO.read(new File("C:\\Users\\1944473\\IdeaProjects\\Projet-Java-et-UML\\model\\src\\main\\resources\\sprites\\fallingRock.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
    
}
