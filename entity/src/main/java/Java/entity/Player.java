package Java.entity;

public class Player extends Entity
{
    
    private static Player ourInstance = new Player();
    IDestructable destructableP;
    IDestructable destructableE;
    private char sprite = 'p';

    private Player()
    {
        super();
        destructableP = new FallableDestrutable();
        destructableE = new EnnemyDestructable();
    }
    public static Player getInstance(int x, int y)
    {
        ourInstance.x = x;
        ourInstance.y = y;
        return ourInstance;
    }

    /*
    Move the player Up by incrementing y
     */
    public void moveUp()
    {
        ourInstance.y++;
    }

    /*
    Move the player Down by decrementing y
     */
    public void moveDown()
    {
        ourInstance.y--;
    }

    /*
    Move the player Left by incrementing x
     */
    public void moveLeft()
    {
        ourInstance.x--;
    }

    /*
        Move the player Right by decrementing x
    */
    public void moveRight()
    {
        ourInstance.x++;
    }

    @Override
    public char getSprite() {
        return sprite;
    }
}

