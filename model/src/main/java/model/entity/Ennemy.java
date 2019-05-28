package model.entity;

import model.entity.entityBehaviours.FallableDestrutable;
import model.entity.entityBehaviours.IDestructable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Ennemy extends Entity
{
    
    IDestructable destructableF;
    private char sprite = 'm';

    public Ennemy(int x, int y, Entity[][] map)
    {
        super(x, y, map);
        destructableF = new FallableDestrutable();
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    @Override
    public Image getImage() throws IOException
    {
        return ImageIO.read(new File("C:\\Users\\1944473\\IdeaProjects\\Projet-Java-et-UML\\sprites\\ennemy.png"));
    }
    
}
