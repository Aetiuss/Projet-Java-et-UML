package entity;

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

    public Entity(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.sprite = getSprite();
    }
    public Entity()
    {}

    public char getSprite(){
        return this.sprite;
    }
    
}
