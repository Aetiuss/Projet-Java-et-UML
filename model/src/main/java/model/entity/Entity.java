package model.entity;

/**
 * The Class entity.
 *
 * @author Jean-Aymeric Diet
 */

public abstract class Entity
{
    
    public int x;
    public int y;
    public char sprite;
    Entity[][] map;

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
    
}
