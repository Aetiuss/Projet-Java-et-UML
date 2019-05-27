package Java.entity;

public class Player extends Entity
{
    
    private static Player ourInstance = new Player();
    IDestructable destructableP;
    IDestructable destructableE;
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
    private void moveUp()
    {
    
    }
    
    private void moveDown()
    {
    
    }
    
    private void moveRight()
    {
    
    }
    
    private void moveLeft()
    {
    
    }
    
}

