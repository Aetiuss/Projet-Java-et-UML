package model.entity;

import model.entity.entityBehaviours.EnnemyDestructable;
import model.entity.entityBehaviours.FallableDestrutable;
import model.entity.entityBehaviours.IDestructable;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Player extends Entity
{
    
    private static Player ourInstance = new Player();
    private        char   sprite      = 'p';
    IDestructable destructableF;
    IDestructable destructableE;
    
    private Player()
    {
        super();
        destructableF = new FallableDestrutable();
        destructableE = new EnnemyDestructable();
    }
    
    public static Player getInstance()
    {
        return ourInstance;
    }
    
    public static Player getInstance(int x, int y, Entity[][] map)
    {
        ourInstance.x = x;
        ourInstance.y = y;
        ourInstance.map = map;
        return ourInstance;
    }
    /*
        Move the player Up by incrementing y
         */
    public void moveUp()
    {
        if (map[x][y--].sprite == 'w')
        {
            ourInstance.y = y;
        }
        else
        {
            map[x][y] = new Empty(x, y, map);
            ourInstance.y--;
            map[x][y] = this;
        }
    }
    /*
    Move the player Down by decrementing y
     */
    public void moveDown()
    {
        if (map[x][y++].sprite == 'w')
        {
            ourInstance.y = y;
        }
        else
        {
            map[x][y] = new Empty(x, y, map);
            ourInstance.y++;
            map[x][y] = this;
        }
    }
    /*
    Move the player Left by incrementing x
     */
    public void moveLeft()
    {
        if (map[x--][y].sprite == 'w')
        {
            ourInstance.x = x;
        }
        else
        {
            map[x][y] = new Empty(x, y, map);
            ourInstance.x--;
            map[x][y] = this;
        }
    }
    /*
        Move the player Right by decrementing x
    */
    public void moveRight()
    {
        if (map[x++][y].sprite == 'w')
        {
            ourInstance.x = x;
        }
        else
        {
            map[x][y] = new Empty(x, y, map);
            ourInstance.x++;
            map[x][y] = this;
        }
    }
    @Override
    public char getSprite()
    {
        return sprite;
    }
    @Override
    public void loadImage()
    {
        try
        {
            this.image = ImageIO.read(new File("C:\\Users\\1944473\\IdeaProjects\\Projet-Java-et-UML\\model\\src\\main\\resources\\sprites\\player.png"));
        }
        catch (final IOException e)
        {
            e.printStackTrace();
        }
    }
    
}

