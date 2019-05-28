package model.entity;

import contract.showboard.IPawn;
import model.entity.entityBehaviours.Fallable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The Class entity.
 *
 * @author Jean-Aymeric Diet
 */

public abstract class Entity implements IPawn
{
    
    public int x;
    public int y;
    public char sprite;
    public Entity[][] map;
    Fallable fallable;
    Image    image;

    public Entity(int x, int y, Entity[][] map)
    {
        this.x = x;
        this.y = y;
        this.sprite = getSprite();
        this.map = map;
    }
    public Entity()
    {}

    public char getSprite(){
        return this.sprite;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Point getPosition() {
        return new Point(this.x, this.y);
    }

    @Override
    public Image getImage() throws IOException
    {
        return ImageIO.read(new File("C:\\Users\\1944473\\IdeaProjects\\Projet-Java-et-UML\\sprites\\"));
    }
    @Override
    public void setImage() throws IOException
    {
        this.image = getImage();
    }
    
}
