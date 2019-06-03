package model.entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Player extends Entity
{
    
    private static Player ourInstance = new Player();
    private        char   sprite      = 'p';
    
    Exit exit = Exit.getInstance();
    
    private Player()
    {
        super();
        loadImage();
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
        if (map[x][y - 1].getSprite() != 'w')
        {
            if (map[x][y - 1].getSprite() != 'f')
            {
                if (map[x][y - 1].getSprite() == 'd')
                {
                    map[x][y - 1].collectibleP.collect();
    
                }
                else if (map[x][y - 1].getSprite() == 'e')
                {
                    exit.exitOpen();
                }
                map[x][y] = new Empty(x, y, map);
                ourInstance.y--;
                map[x][y] = this;
            }
        }
    }
    /*
    Move the player Down by decrementing y
     */
    public void moveDown()
    {
        if (map[x][y + 1].getSprite() != 'w')
        {
            if (map[x][y + 1].getSprite() != 'f')
            {
                if (map[x][y + 1].getSprite() == 'd')
                {
                    map[x][y + 1].collectibleP.collect();
                }
                else if (map[x][y + 1].getSprite() == 'e')
                {
                    exit.exitOpen();
                }
                map[x][y] = new Empty(x, y, map);
                ourInstance.y++;
                map[x][y] = this;
            }
    
    
        }
    }
    /*
    Move the player Left by incrementing x
     */
    public void moveLeft()
    {
        if (map[x - 1][y].getSprite() != 'w')
        {
            if (map[x - 1][y].getSprite() != 'f')
            {
                if (map[x - 1][y].getSprite() == 'd')
                {
                    map[x - 1][y].collectibleP.collect();
                }
                else if (map[x - 1][y].getSprite() == 'e')
                {
                    exit.exitOpen();
                }
                map[x][y] = new Empty(x, y, map);
                ourInstance.x--;
                map[x][y] = this;
            }
            else
            {
                if (map[x - 2][y].getSprite() == 'v')
                {
                    map[x - 1][y].pushable.pushLeft();
                    map[x][y] = new Empty(x, y, map);
                    ourInstance.x--;
                    map[x][y] = this;
                }
            }
        }
    }
    /*
        Move the player Right by decrementing x
    */
    public void moveRight()
    {
        if (map[x + 1][y].getSprite() != 'w')
        {
            if (map[x + 1][y].getSprite() != 'f')
            {
                if (map[x + 1][y].getSprite() == 'd')
                {
                    map[x + 1][y].collectibleP.collect();
                }
                else if (map[x + 1][y].getSprite() == 'e')
                {
                    exit.exitOpen();
                }
                map[x][y] = new Empty(x, y, map);
                ourInstance.x++;
                map[x][y] = this;
            }
            else
            {
                if (map[x + 2][y].getSprite() == 'v')
                {
                    map[x + 1][y].pushable.pushRight();
                    map[x][y] = new Empty(x, y, map);
                    ourInstance.x++;
                    map[x][y] = this;
                }
            }
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
            this.image = ImageIO.read(getClass().getClassLoader()
                                                .getResource("./sprites/player.png"));
            if (this.image == null)
            {
                throw new IOException("File is nowhere to be found");
            }
        }
        catch (final IOException e)
        {
            e.printStackTrace();
        }
    }
    
}

