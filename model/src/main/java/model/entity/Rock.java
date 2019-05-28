package model.entity;

import model.entity.entityBehaviours.IDestructable;
import model.entity.entityBehaviours.PlayerDestructable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Rock extends Entity
{
    
    IDestructable destructable;
    private char sprite = 'r';
    
    @Override
    public Image getImage() throws IOException
    {
        return ImageIO.read(new File("C:\\Users\\1944473\\IdeaProjects\\Projet-Java-et-UML\\sprites\\rock.png"));
    }
    public Rock(int x, int y, Entity[][] map)
    {
        super(x, y, map);
        destructable = new PlayerDestructable();
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    
}
