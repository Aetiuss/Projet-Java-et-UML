package entity;

public class Player extends Entity
{
    
    private static Player ourInstance = new Player();
    
    public static Player getInstance(int x, int y)
    {
        ourInstance.x = x;
        ourInstance.y = y;
        return ourInstance;
    }
    
    private Player()
    {
        super();
    }
    
}
